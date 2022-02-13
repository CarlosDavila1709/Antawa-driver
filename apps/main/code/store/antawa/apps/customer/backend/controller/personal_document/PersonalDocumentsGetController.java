package store.antawa.apps.customer.backend.controller.personal_document;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import store.antawa.customer.personal_document.application.PersonalDocumentsResponse;
import store.antawa.customer.personal_document.application.search_all.SearchAllPersonalDocumentQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class PersonalDocumentsGetController  extends ApiController{


    public PersonalDocumentsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    
    @GetMapping("/personal-documents") 
    public JSONObject index() throws QueryHandlerExecutionError {
    
    	PersonalDocumentsResponse documents = ask( new SearchAllPersonalDocumentQuery());
    	
		List<HashMap<String, String>> data = documents.documents().stream().map(response -> new HashMap<String, String>() {{
            put("uid", response.uid());
            put("name", response.name());
        }}).collect(Collectors.toList());
		
		return getResult(HttpStatus.OK.value(),"success", data);
		
    }
    
    private JSONObject getResult(int status, String msg, List<HashMap<String, String>> data ){
    	  
    	JSONObject resp = new JSONObject();
    	resp.put("status", status);
    	resp.put("message", msg);
    	resp.put("data", data);
    	return resp;
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
