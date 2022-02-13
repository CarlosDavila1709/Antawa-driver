package store.antawa.apps.driver.backend.controller.driver;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.application.find.FindDriverQuery;
import store.antawa.driver.driver.domain.DriverNotExist;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class DriverGetController extends ApiController {

	public DriverGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/drivers/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		DriverResponse driver = ask(new FindDriverQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("uid", driver.uid());
				put("names", driver.names());
				put("lastName", driver.lastName());
				put("phoneMobile", driver.phoneMobile());
				put("email", driver.email());
				put("password", driver.password());
				put("numberDocumentPersonal", driver.numberDocumentPersonal());
				put("typeDocumentPersonal", driver.typeDocumentPersonal());

			}
		});
	}
	
	 @Override
	    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
	        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
	            put(DriverNotExist.class, HttpStatus.NOT_FOUND);
	        }};
	    }
}
