package store.antawa.apps.backoffice.backend.controller.solicitud;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.backoffice.solicitud.application.SolicitudesResponse;
import store.antawa.backoffice.solicitud.application.search_all.SearchAllSolicitudQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class SolicitudesGetController extends ApiController{

	
	public SolicitudesGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
	}

    @GetMapping("/solicitudes")
    public HashMap<String, List<HashMap<String, String>>> index() throws QueryHandlerExecutionError {
       
    	SolicitudesResponse solicitudes = ask( new SearchAllSolicitudQuery());
    	HashMap<String, List<HashMap<String, String>>> envolepeSolicitudes = new  HashMap<String, List<HashMap<String, String>>>();
    	
    	List<HashMap<String, String>> resp =  solicitudes.solicitudes().stream().map(response -> new HashMap<String, String>() {
        	
			private static final long serialVersionUID = -7994277711275504994L;

		{
            put("uid", response.uid());
            put("driverUid", response.driverUid());
            put("name", response.namesDriver());
            put("lastName", response.lastNameDriver());
            put("typeDocument", response.document());
            put("numberDocument", response.numberDocument());
            put("status", response.status());
            put("imageCriminalRecord", response.imageCriminalRecord());
            put("imageFaceDriver", response.imageFaceDriver());
            put("imageIdentidad", response.imageIdentidad());
            put("imageSoa", response.imageSoa());
            put("imageVehiculo", response.imageVehiculo());
            put("dateCreation", response.dateCreation());
            
        }}).collect(Collectors.toList());
    	
    	envolepeSolicitudes.put("solicitudes", resp);
    	
    	return envolepeSolicitudes;
    }
    
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		// TODO Auto-generated method stub
		return null;
	}
}

class ResponseConductores{
	
	private List<HashMap<String, String>> solicitudes;
	
	public void setSolicitudes(List<HashMap<String, String>> solicitudes) {
		
		this.solicitudes = solicitudes;
		
	}
	
	public List<HashMap<String, String>> solicitudes(){
		
		return solicitudes;
	
	}
}