package store.antawa.apps.backoffice.backend.controller.loguer;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import store.antawa.backoffice.user.UserResponse;
import store.antawa.backoffice.user.application.loguer.LoguerUserBackofficeQuery;
import store.antawa.backoffice.user.domain.UserNotExist;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class LoguerGetController extends ApiController{

	public LoguerGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/users-loguer/{email}/{password}")
	public JSONObject index(@PathVariable String email, @PathVariable String password) throws QueryHandlerExecutionError 
	{
		UserResponse reponse = ask(new LoguerUserBackofficeQuery(email,password));
		
		 
		HashMap<String, Serializable> data = new HashMap<String, Serializable>();
		data.put("uid", reponse.uid());
		data.put("names", reponse.names());
		data.put("lastName", reponse.lastName());
		data.put("email", reponse.email());
		
		return getResult(HttpStatus.OK.value(),"success", data);
		
	}
	
    private JSONObject getResult(int status, String msg,HashMap<String, Serializable> data){
  	  
    	JSONObject resp = new JSONObject();
    	resp.put("status", status);
    	resp.put("message", msg);
    	resp.put("data", data);
    	return resp;
    }
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			private static final long serialVersionUID = -48820367473019064L;

		{
            put(UserNotExist.class, HttpStatus.NOT_FOUND);
        }};
	}
	
	
}
final class Request {
	
    private String email;
    private String password;
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    String email() {
    	return email;
    }
    String password() {
    	return password;
    }
}
