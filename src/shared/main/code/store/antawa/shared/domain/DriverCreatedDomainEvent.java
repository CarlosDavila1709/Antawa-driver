package store.antawa.shared.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.antawa.shared.domain.bus.event.DomainEvent;

public final class DriverCreatedDomainEvent extends DomainEvent {

    private final String email;
    
    public DriverCreatedDomainEvent() {
    	super(null);
    	this.email = null;
    }
    
    public DriverCreatedDomainEvent(String aggregateId, String email) {
    	
    	super(aggregateId);
    	
    	this.email = email;
    }
    
    public DriverCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String email) {
    	
    	 super(aggregateId, eventId, occurredOn);
    	 this.email     = email;
    }
    
    @Override
    public String eventName() {
        return "driver.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("email", email);
        }};
    }
    
    @Override
    public DriverCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new DriverCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("email")
        );
    }
    
    public String email() {
        return email;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DriverCreatedDomainEvent that = (DriverCreatedDomainEvent) o;
        return email.equals(that.email) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
