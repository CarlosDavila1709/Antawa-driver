package store.antawa.shared.infrastructure.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.NestedServletException;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.Utils;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

public final class ApiExceptionMiddleware implements Filter {
    private RequestMappingHandlerMapping mapping;

    public ApiExceptionMiddleware(RequestMappingHandlerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws ServletException {
        HttpServletRequest  httpRequest  = ((HttpServletRequest) request);
        HttpServletResponse httpResponse = ((HttpServletResponse) response);

        try {
            Object possibleController = (
                (HandlerMethod) Objects.requireNonNull(
                    mapping.getHandler(httpRequest)).getHandler()
            ).getBean();

            try {
                chain.doFilter(request, response);
            } catch (NestedServletException exception) {
                if (possibleController instanceof ApiController) {
                    handleCustomError(response, httpResponse, (ApiController) possibleController, exception);
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void handleCustomError(
        ServletResponse response,
        HttpServletResponse httpResponse,
        ApiController possibleController,
        NestedServletException exception
    ) throws IOException {
        HashMap<Class<? extends DomainError>, HttpStatus> errorMapping = possibleController
            .errorMapping();
        Throwable error = (
            exception.getCause() instanceof CommandHandlerExecutionError ||
            exception.getCause() instanceof QueryHandlerExecutionError
        )
            ? exception.getCause().getCause() : exception.getCause();

        int    statusCode   = statusFor(errorMapping, error);
        String errorCode    = errorCodeFor(error);
        //String errorMessage = error.getMessage();
        String errorMessage = errorMsgFor(error);
        
        httpResponse.reset();
        httpResponse.setHeader("Content-Type", "application/json");
        httpResponse.setStatus(statusCode);
        PrintWriter writer = response.getWriter();
        writer.write(String.format(
            "{\"error_code\": \"%s\", \"message\": \"%s\"}",
            errorCode,
            errorMessage
        ));
        writer.close();
    }

    private String errorCodeFor(Throwable error) {
        if (error instanceof DomainError) {
            return ((DomainError) error).errorCode();
        }
        if (error instanceof CommandHandlerExecutionError) {
        	CommandHandlerExecutionError err = ((CommandHandlerExecutionError) error);
        	return ((DomainError) err.getCause()).errorCode();
        }

        return Utils.toSnake(error.getClass().toString());
    }

    private String errorMsgFor(Throwable error) {
        if (error instanceof DomainError) {
            return error.getMessage();
        }
        if (error instanceof CommandHandlerExecutionError) {
        	CommandHandlerExecutionError err = ((CommandHandlerExecutionError) error);
        	return ((DomainError) err.getCause()).errorMessage();
        }
		return "S/N";
    }
    private int statusFor(HashMap<Class<? extends DomainError>, HttpStatus> errorMapping, Throwable error) {
        if (error instanceof CommandHandlerExecutionError) {
        	CommandHandlerExecutionError err = ((CommandHandlerExecutionError) error);
        	return errorMapping.getOrDefault(err.getCause().getClass(), HttpStatus.INTERNAL_SERVER_ERROR).value();
        }
    	
    	return errorMapping.getOrDefault(error.getClass(), HttpStatus.INTERNAL_SERVER_ERROR).value();
    }
}
