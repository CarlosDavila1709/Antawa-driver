package store.antawa.apps.backoffice.backend.controller.uploads;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.minidev.json.JSONObject;
import store.antawa.backoffice.uploads.application.to_attach.AttachFileCommand;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
public final class UploadDocumentSolicitudPutController extends ApiController{

	public UploadDocumentSolicitudPutController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
		
	}
	
    @PostMapping(value = "/uploads/solicitudes/{solicitudUid}/type/{typedocument}")
    public JSONObject index(
    		@PathVariable String solicitudUid, 
    		@PathVariable String typedocument, 
    		@RequestParam("file") MultipartFile file ) throws CommandHandlerExecutionError {
    
    	try {
			
    		dispatch(new AttachFileCommand( solicitudUid, typedocument, file.getBytes()));
		
    	
    	} catch (IOException e) {
    		
    		throw new CommandHandlerExecutionError(e);
		}
    	

        return getResult(HttpStatus.CREATED.value(),HttpStatus.CREATED.toString());
					
    }

    
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
           
        }};
	 }
	
    private JSONObject getResult(int status, String msg){
  	  
    	JSONObject resp = new JSONObject();
    	resp.put("status", status);
    	resp.put("message", msg);
    	return resp;
    }
	
}


final class Request {
	
	private MultipartFile file;
	
	
	public void setFile() {
		
	}
	
	public MultipartFile file() {
		
		return file;
	}
	
}