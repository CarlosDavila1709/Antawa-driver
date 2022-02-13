package store.antawa.apps.customer.backend.controller.personal_document;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.antawa.customer.personal_document.application.PersonalDocumentResponse;
import store.antawa.customer.personal_document.application.find.FindPersonalDocumentQuery;
import store.antawa.customer.personal_document.domain.PersonalDocumentNotExist;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public final class PersonalDocumentGetController extends ApiController{

	public PersonalDocumentGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/personal-documents/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
			throws QueryHandlerExecutionError {
		
		PersonalDocumentResponse document = ask(new FindPersonalDocumentQuery(id));

		return ResponseEntity.ok().body(new HashMap<String, Serializable>() {
			{
				put("uid", document.uid());
				put("name", document.name());
			}
		});
	}
	
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(PersonalDocumentNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
