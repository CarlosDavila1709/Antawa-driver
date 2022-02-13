package store.antawa.apps.backoffice.backend.controller.solicitud;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.backoffice.solicitud.application.find.FindSolicitudQuery;
import store.antawa.driver.driver.domain.DriverNotExist;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class SolicitudGetController  extends ApiController{

	public SolicitudGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}


	@GetMapping("/solicitudes/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		SolicitudResponse solicitud = ask(new FindSolicitudQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			private static final long serialVersionUID = 7459022863601645584L;

			{
	            put("uid", solicitud.uid());
	            put("driverUid", solicitud.driverUid());
	            put("name", solicitud.namesDriver());
	            put("lastName", solicitud.lastNameDriver());
	            put("typeDocument", solicitud.document());
	            put("numberDocument", solicitud.numberDocument());
	            put("status", solicitud.status());
	            put("imageCriminalRecord", solicitud.imageCriminalRecord());
	            put("imageFaceDriver", solicitud.imageFaceDriver());
	            put("imageIdentidad", solicitud.imageIdentidad());
	            put("imageSoa", solicitud.imageSoa());
	            put("imageVehiculo", solicitud.imageVehiculo());
	            put("dateCreation", solicitud.dateCreation());

			}
		});
	}
	
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			private static final long serialVersionUID = -48820367473019064L;

		{
            put(DriverNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
