package store.antawa.shared.domain.events.uploads;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import store.antawa.shared.domain.bus.event.DomainEvent;

public final class FileUploadedDomainEvent extends DomainEvent{

    private final String ownerUid;
    private final String typeDocument;
    private final String name;
    
    public FileUploadedDomainEvent() {
    	super(null);
    	this.ownerUid 		  = null;
    	this.typeDocument     = null;
    	this.name   		  = null;
    }
    
   public FileUploadedDomainEvent(String aggregateId, String ownerUid, String typeDocument, String name) {
    	
    	super(aggregateId);
    	
    	this.ownerUid 		   = ownerUid;
    	this.typeDocument      = typeDocument;
    	this.name			   = name;
    }
    
    public FileUploadedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String ownerUid,
            String typeDocument,
            String name) {
    	
    	 super(aggregateId, eventId, occurredOn);
    	 this.ownerUid         = ownerUid;
    	 this.typeDocument     = typeDocument;
    	 this.name			   = name;
    }
    
    @Override
    public String eventName() {
        return "file.uploaded";
    }
    
    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("ownerUid", ownerUid);
            put("typeDocument", typeDocument);
            put("name", name);
        }};
    }
    
    @Override
    public FileUploadedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new FileUploadedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("driverUid"),
            (String) body.get("typeDocument"),
            (String) body.get("name")
        );
    }
    
    public String ownerUid() {
        return ownerUid;
    }
    public String typeDocument() {
        return typeDocument;
    }
    public String name() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileUploadedDomainEvent that = (FileUploadedDomainEvent) o;
        return  ownerUid.equals(that.ownerUid) &&
        		typeDocument.equals(that.typeDocument) &&
        		name.equals(that.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerUid, typeDocument, name);
    }
}
