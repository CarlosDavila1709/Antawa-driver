package store.antawa.apps.backoffice.backend.controller.document_type;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import store.antawa.backoffice.document_type.application.TypeDocumentResponse;
import store.antawa.backoffice.document_type.application.find.FindTypeDocumentQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
public final class DocumentTypeGetController extends ApiController{
	
	
	public DocumentTypeGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	
	@GetMapping("/documents-types/{uid}")
	public JSONObject index(@PathVariable String uid) throws QueryHandlerExecutionError {
		
		TypeDocumentResponse documents = ask(new FindTypeDocumentQuery(uid));

		 
		HashMap<String, Serializable> data = new HashMap<String, Serializable>();
        data.put("uid", documents.uid());
        data.put("name", documents.name());
        data.put("codigo", documents.codigo());
		
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
		// TODO Auto-generated method stub
		return null;
	}
}
