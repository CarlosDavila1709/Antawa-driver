package store.antawa.shared.domain.events.driver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.antawa.shared.domain.bus.event.DomainEvent;

public final class DriverDocumentCreatedDomainEvent extends DomainEvent{

    private final String driverUid;
    private final String documentTypeUid;
    private final String image;
    
    public DriverDocumentCreatedDomainEvent() {
    	
    	super(null);
    	this.driverUid = null;
    	this.documentTypeUid = null;
    	this.image = null;
    	
    }
    
    public DriverDocumentCreatedDomainEvent(String aggregateId, String driverUid, String documentTypeUid, String image) {
    	
    	super(null);
    	this.driverUid = driverUid;
    	this.documentTypeUid = documentTypeUid;
    	this.image = image;
    	
    }
    public DriverDocumentCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String driverUid,
            String documentTypeUid,
            String image) {
    	
    	 super(aggregateId, eventId, occurredOn);
    	 this.driverUid     	 = driverUid;
    	 this.documentTypeUid    = documentTypeUid;
    	 this.image     		 = image;
    	 
    }
    
    @Override
    public String eventName() {
        return "driverdocument.created";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("driverUid", driverUid);
            put("documentTypeUid", documentTypeUid);
            put("image", image);
        }};
    }
    @Override
    public DriverDocumentCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new DriverDocumentCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("driverUid"),
            (String) body.get("documentTypeUid"),
            (String) body.get("image")
        );
    }
    
    public String driverUid() {
        return driverUid;
    }
    
    public String documentTypeUid() {
        return documentTypeUid;
    }
    
    public String image() {
        return image;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DriverDocumentCreatedDomainEvent that = (DriverDocumentCreatedDomainEvent) o;
        return  driverUid.equals(that.driverUid) &&
        		documentTypeUid.equals(that.documentTypeUid) &&
        		image.equals(that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverUid, documentTypeUid, image);
    }
}
