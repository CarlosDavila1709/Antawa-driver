package store.antawa.backoffice.test;

import org.springframework.context.event.EventListener;

import store.antawa.shared.domain.DriverCreatedDomainEvent;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({DriverCreatedDomainEvent.class})
public class Prueba {

    @EventListener
	public void on(DriverCreatedDomainEvent event) {

    	System.out.print("ejecuta prueba desde backoffice");

    }
}
