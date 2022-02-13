package store.antawa.backoffice.solicitud.application.create;

import org.springframework.context.event.EventListener;

import store.antawa.shared.domain.DriverCreatedDomainEvent;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({DriverCreatedDomainEvent.class})
public class CreateSolicitudFileCreated {

	private final SolicitudCreator creator;
	
	public CreateSolicitudFileCreated(SolicitudCreator creator) {
		
		this.creator = creator;
	}
	
    @EventListener
	public void on(DriverCreatedDomainEvent event) {

    	creator.creator(event.aggregateId());
    	
    }
}
