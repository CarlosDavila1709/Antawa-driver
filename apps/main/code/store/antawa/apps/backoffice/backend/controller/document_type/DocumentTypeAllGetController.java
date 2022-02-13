package store.antawa.apps.backoffice.backend.controller.document_type;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import store.antawa.backoffice.document_type.application.TypeDocumentsResponse;
import store.antawa.backoffice.document_type.application.search_all.SearchAllDocumentTypeQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
public final class DocumentTypeAllGetController extends ApiController{

	
	public DocumentTypeAllGetController(QueryBus queryBus, CommandBus commandBus) {
		 super(queryBus, commandBus);
	}

	@GetMapping("/documents-types")
	public JSONObject index() throws QueryHandlerExecutionError {
		
		TypeDocumentsResponse documents = ask(new SearchAllDocumentTypeQuery());

		List<HashMap<String, String>> data = documents.types().stream().map(response -> new HashMap<String, String>() {{
	            put("uid", response.uid());
	            put("name", response.name());
	            put("codigo", response.codigo());
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
		// TODO Auto-generated method stub
		return null;
	}
}
