package store.antawa.backoffice.solicitud.application.to_attach;

import org.springframework.context.event.EventListener;

import store.antawa.backoffice.uploads.domain.OwnerUid;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.backoffice.uploads.domain.UploadsType;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.event.DomainEventSubscriber;
import store.antawa.shared.domain.events.uploads.FileUploadedDomainEvent;

@Service
@DomainEventSubscriber({FileUploadedDomainEvent.class})
public class AttachDocumentFileUploads {

	private final DocumentAttached attacher;
	
	public AttachDocumentFileUploads(DocumentAttached attacher) {
		
		this.attacher = attacher;
	}
	
    @EventListener
	public void on(FileUploadedDomainEvent event) {
	
    	OwnerUid ownerUid 			= new OwnerUid(event.ownerUid());
    	UploadsType uploadsType 	= new UploadsType(event.typeDocument());
    	UploadsName uploadsName     = new UploadsName(event.name());
    	
    	attacher.attached(ownerUid, uploadsType, uploadsName);
	}
}
