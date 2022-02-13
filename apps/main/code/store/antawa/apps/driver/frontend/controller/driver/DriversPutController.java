package store.antawa.apps.driver.frontend.controller.driver;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import store.antawa.driver.driver.application.create.CreateDriverCommand;
import store.antawa.driver.driver.domain.InvalidDriverExistsEmail;
import store.antawa.driver.driver.domain.InvalidDriverExistsUID;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.infrastructure.spring.ApiController;
import store.antawa.shared.infrastructure.validation.ValidationResponse;
import store.antawa.shared.infrastructure.validation.Validator;

@Controller
public final class DriversPutController implements Serializable {

	private static final long serialVersionUID = -6543072544151841086L;


	private final CommandBus bus;
	
		 
	/*public DriversPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}*/
	 private final HashMap<String, String> rules = new HashMap<String, String>() {

		private static final long serialVersionUID = -8097278198761332109L;

	{
        put("id", "required|not_empty|uuid");
        put("names", "required|not_empty|string");
        put("lastName", "required|not_empty|string");
        put("phoneMobile", "required|not_empty|string");
        put("email", "required|not_empty|string");
        put("password", "required|not_empty|string");
    }};
    
	public DriversPutController(QueryBus queryBus, CommandBus bus) {
		 this.bus = bus;
	}
	
    @PostMapping(value = "/drivers",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView index(
        @RequestParam HashMap<String, Serializable> request, RedirectAttributes attributes
    ) throws CommandHandlerExecutionError,Exception {
        
    	//bus.dispatch(new CreateDriverCommand(id, request.names(), request.lastName(), request.phoneMobile(), request.email(), request.password()));
    	//return new ResponseEntity<>(HttpStatus.CREATED);
    	ValidationResponse validationResponse = Validator.validate(request, rules);
    	return validationResponse.hasErrors()
                ? redirectWithErrors(validationResponse, request, attributes)
                : createDriver(request);
    }
    
    private RedirectView redirectWithErrors(
            ValidationResponse validationResponse,
            HashMap<String, Serializable> request,
            RedirectAttributes attributes
        ) {
            attributes.addFlashAttribute("errors", validationResponse.errors());
            attributes.addFlashAttribute("inputs", request);

            return new RedirectView("/drivers");
   }
    private RedirectView createDriver(HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
    	bus.dispatch(new CreateDriverCommand(
    			request.get("id").toString(), 
    			request.get("names").toString(), 
    			request.get("lastName").toString(), 
    			request.get("phoneMobile").toString(),
    			request.get("email").toString(),
    			request.get("password").toString(),
    			request.get("personalDocumentUid").toString(),
    			request.get("numberDocument").toString()));

        return new RedirectView("/drivers");
    }
    /*
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				 put(InvalidDriverExistsEmail.class, HttpStatus.CONFLICT);
				 put(InvalidDriverExistsUID.class, HttpStatus.CONFLICT);
			}
		};
	}*/
}

final class Request {

	private String id;
    private  String names;
    private  String lastName;
    private  String phoneMobile;
    private  String email;
    private  String password;
    private  String personalDocumentUid;
    private  String numberDocument;

    public void setId(String id) {
    	this.id   = id;
    }
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
    String id() {
    	return id;
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
