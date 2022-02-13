package store.antawa.apps.driver.backend.controller.personal_document;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.driver.personal_document.application.PersonalDocumentsResponse;
import store.antawa.driver.personal_document.application.search_all.SearchAllPersonalDocumentQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class PersonalDocumentsGetController extends ApiController {

    public PersonalDocumentsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    
    @GetMapping("/personal-documents") 
    public List<HashMap<String, String>> index() throws QueryHandlerExecutionError {
    
    	PersonalDocumentsResponse documents = ask( new SearchAllPersonalDocumentQuery());
    	
		return documents.documents().stream().map(response -> new HashMap<String, String>() {
			{
				put("uid", response.uid());
				put("name", response.name());
			}
		}).collect(Collectors.toList());
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
