package store.antawa.driver.test;

import org.springframework.context.event.EventListener;

import store.antawa.shared.domain.DriverCreatedDomainEvent;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({DriverCreatedDomainEvent.class})
public final class TestEvent {

    @EventListener
	public void on(DriverCreatedDomainEvent event) {

    	System.out.print("chapo driver...");
    }
}
