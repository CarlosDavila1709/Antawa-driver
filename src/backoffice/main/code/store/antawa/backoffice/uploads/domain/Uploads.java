package store.antawa.backoffice.uploads.domain;

import store.antawa.shared.domain.AggregateRoot;
import store.antawa.shared.domain.events.uploads.FileUploadedDomainEvent;

public final class Uploads  extends AggregateRoot {

	private UploadsUid 	uid;
	
	private OwnerUid	ownerUid;

	private UploadsFile file;
	
	private UploadsPath path;
	
	private UploadsName name;
	
	public Uploads(UploadsUid uid, OwnerUid ownerUid, UploadsFile file, UploadsPath path, UploadsName name) {
		
		this.uid  = uid;
		this.ownerUid = ownerUid;   
		this.file = file;
		this.path = path;
		this.name = name;
		
	}
	
	public Uploads() {
		this.uid  		= null;
		this.ownerUid 	= null;   
		this.file 		= null;
		this.path 		= null;
		this.name 		= null;
	}
	public static Uploads create(UploadsUid uid, OwnerUid ownerUid, UploadsType uploadsType, UploadsFile file, UploadsPath path, UploadsName name) {
		
		Uploads uploads = new Uploads( uid, ownerUid, file, path, name );
		
		//uploads.record(new FileUploadedDomainEvent( uid.value(), ownerUid.value(), typeUid.value(), name.value() ));
		uploads.record(new FileUploadedDomainEvent( uid.value(), ownerUid.value(), uploadsType.value(), name.value() ));
		
		return uploads;
	}
	
	public UploadsUid uid() {
	
		return uid;
	}

	public OwnerUid ownerUid() {
		
		return ownerUid;
	}

	public UploadsFile file() {
		return file;
	}
	
	public UploadsPath path() {
		return path;
	}
	
	public UploadsName name() {
		return name;
	}
}
