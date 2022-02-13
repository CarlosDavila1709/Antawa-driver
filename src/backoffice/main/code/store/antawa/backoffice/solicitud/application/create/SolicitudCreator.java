package store.antawa.backoffice.solicitud.application.create;

import java.time.LocalDateTime;

import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.backoffice.solicitud.domain.SolicitudDateCreation;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.backoffice.solicitud.domain.SolicitudStatus;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.application.find.FindDriverQuery;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.Utils;
import store.antawa.shared.domain.UuidGenerator;
import store.antawa.shared.domain.bus.query.QueryBus;

@Service
public final class SolicitudCreator {
	private final SolicitudRepository repository;
	private final QueryBus      	  queryBus;
	private final UuidGenerator 	  uuidGenerator;
	
	public SolicitudCreator(SolicitudRepository repository, QueryBus queryBus,UuidGenerator  uuidGenerator) {
		
		this.repository 	= repository;
		this.queryBus   	= queryBus;
		this.uuidGenerator 	= uuidGenerator;
	}
	
	public void creator(String driverUid) {
		
		DriverResponse driver = queryBus.ask(new FindDriverQuery(driverUid));
		
		String namesDriver 		= driver.names();
		String lastNameDriver 	= driver.lastName();
		String typeDocument     = driver.typeDocumentPersonal();
		String numberDocument   = driver.numberDocumentPersonal();

		Solicitud solicitud = Solicitud.create(
											new SolicitudUid(uuidGenerator.generate()), 
											driverUid,
											namesDriver,
											lastNameDriver,
											typeDocument, 
											numberDocument,  
											new SolicitudStatus(SolicitudStatus.received()),
											"",
											"",
											"",
											"",
											"",
											"",
											new SolicitudDateCreation(Utils.dateToString(LocalDateTime.now())));
		
		repository.save(solicitud);
	}
}
