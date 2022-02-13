package store.antawa.apps.backoffice.backend.controller.solicitud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.backoffice.solicitud.application.update_state.SolicitudNewStateCommand;
import store.antawa.backoffice.solicitud.domain.SolicitudStatusNotAdmittedError;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.command.CommandHandlerExecutionError;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins="*")
public final class SolicitudNewStatePutController extends ApiController {

	public SolicitudNewStatePutController(QueryBus queryBus, CommandBus commandBus) {
		
		super(queryBus, commandBus);
		
	}

    @PutMapping(value = "/solicitudes/{solicitudUid}/state/{state}")
    public ResponseEntity<String> index(
    		@PathVariable String solicitudUid, 
    		@PathVariable String state,
    		@RequestBody RequestObservacion requestObservacion) throws CommandHandlerExecutionError {

    	dispatch(new SolicitudNewStateCommand(solicitudUid, state, requestObservacion.observacion() == null? "": requestObservacion.observacion()));
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {

			private static final long serialVersionUID = 8125610613604697085L;

		{
			  put(SolicitudStatusNotAdmittedError.class, HttpStatus.NOT_FOUND);
        }};
	}
}

final class RequestObservacion {
	
	private String observacion;
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	String observacion() {
		return observacion;
	}
}
