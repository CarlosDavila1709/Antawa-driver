package store.antawa.apps.backoffice.backend.controller.uploads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import javax.activation.FileTypeMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.backoffice.uploads.application.FileResponse;
import store.antawa.backoffice.uploads.application.load_file.FindFileByNameQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class UploadDocumentSolicitudGetController extends ApiController{

	public UploadDocumentSolicitudGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		
	}

	@GetMapping(value="/uploads/solicitudes/name/{name}")
	public ResponseEntity<byte[]> index(@PathVariable String name) throws QueryHandlerExecutionError, IOException{
    	
		FileResponse response = ask(new FindFileByNameQuery(name));
		
		File file = new File(response.path());
	    
		return ResponseEntity.ok()
	            .header("Content-Disposition", "attachment; filename=" +file.getName())
	            .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
	            .body(Files.readAllBytes(file.toPath()));
		
	}
    
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
           
        }};
	 }
	
}
