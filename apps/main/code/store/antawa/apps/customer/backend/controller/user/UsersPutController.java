package store.antawa.apps.customer.backend.controller.user;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import store.antawa.customer.user.application.create.CreateUserCommand;
import store.antawa.customer.user.domain.InvalidUseremail;
import store.antawa.customer.user.domain.InvalidUserphonemobil;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public final class UsersPutController extends ApiController{

	public UsersPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		
	}

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) 
    									throws QueryHandlerExecutionError,CommandHandlerExecutionError{
    	
    	dispatch(new CreateUserCommand(
    			id,
    			request.names(),
    			request.lastName(),
    			request.phoneMobile(),
    			request.email(),
    			request.password(),
    			request.personalDocumentUid(),
    			request.numberDocument()));
    	
        return new ResponseEntity<>(getResult(HttpStatus.CREATED.value(),HttpStatus.CREATED.toString()),
				HttpStatus.CREATED);
    }
    	
    
    private String getResult(int status, String msg){
  	  
    	JSONObject resp = new JSONObject();
    	resp.put("status", status);
    	resp.put("message", msg);
    	return resp.toString();
    }
    
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(InvalidUseremail.class, HttpStatus.CONFLICT);
				put(InvalidUserphonemobil.class, HttpStatus.CONFLICT);
			}
		};
	}

}
final class Request {

    private String names;
    private String lastName;
    private String phoneMobile;
    private String email;
    private String password;
    private String personalDocumentUid;
    private String numberDocument;
    
    public void setNames(String names) {
    	this.names = names;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    public void setPhoneMobile(String phoneMobile) {
    	this.phoneMobile = phoneMobile;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setPersonalDocumentUid(String personalDocumentUid) {
    	this.personalDocumentUid = personalDocumentUid;
    }
    public void setNumberDocument(String numberDocument) {
    	this.numberDocument = numberDocument;
    }
    
    String names() {
    	return names;
    }
    String lastName() {
    	return lastName;
    }
    String phoneMobile() {
    	return phoneMobile;
    }
    String email() {
    	return email;
    }
    String password() {
    	return password;
    }
    String personalDocumentUid() {
    	return personalDocumentUid;
    }
    String numberDocument() {
    	return numberDocument;
    }
}
