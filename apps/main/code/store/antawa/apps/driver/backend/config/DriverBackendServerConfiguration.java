package store.antawa.apps.driver.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import store.antawa.shared.infrastructure.spring.ApiExceptionMiddleware;

@Configuration
public class DriverBackendServerConfiguration {

	private final RequestMappingHandlerMapping mapping;
	
	public DriverBackendServerConfiguration(RequestMappingHandlerMapping mapping) {
        this.mapping = mapping;
	}
	
    @Bean
    public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiExceptionMiddleware(mapping));
        
        
        return registrationBean;
    }
    
}
