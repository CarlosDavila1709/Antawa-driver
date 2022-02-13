package store.antawa.backoffice.uploads.application.to_attach;

import store.antawa.backoffice.uploads.domain.UploadsFile;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.backoffice.uploads.domain.UploadsPath;
import store.antawa.backoffice.uploads.domain.UploadsRepository;
import store.antawa.backoffice.uploads.domain.UploadsType;
import store.antawa.backoffice.uploads.domain.UploadsUid;
import store.antawa.backoffice.uploads.domain.FileSystemRepository;
import store.antawa.backoffice.uploads.domain.OwnerUid;
import store.antawa.backoffice.uploads.domain.Uploads;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.UuidGenerator;
import store.antawa.shared.domain.bus.event.EventBus;
import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;

@Service
public final class FileAttached {
	
	private UuidGenerator            	uuidGenerator;
	private final FileSystemRepository  fileSystemRepository;
	private final EventBus         		eventBus;
	private final UploadsRepository 	repository;
	private final Parameter 			config;
	private final static String  		URL_UPLOADS = "UPLOADS_DOCUMENTS_DRIVER_DOCUMENTS";
	private final static String  		EXTEN_JPG = ".jpg";
	
	public FileAttached(UploadsRepository repository,FileSystemRepository fileSystemRepository,EventBus eventBus, Parameter config, UuidGenerator uuidGenerator) {
		this.repository 		  = repository;
		this.fileSystemRepository = fileSystemRepository;
		this.eventBus			  = eventBus;
		this.config				  = config;
		this.uuidGenerator		  = uuidGenerator;
	}

	public void attached(OwnerUid ownerUid, UploadsType uploadsType, UploadsFile file) {
		
		UploadsUid uid 			= new UploadsUid(uuidGenerator.generate());
		UploadsName name 		= new UploadsName(uid.value() + EXTEN_JPG );
		UploadsPath path 		= new UploadsPath(getPath(name));
		
		Uploads uploads 		= Uploads.create(uid, ownerUid, uploadsType, file, path, name);

		repository.save(uploads);
		fileSystemRepository.save(uploads);
		
		eventBus.publish(uploads.pullDomainEvents());
		
	}
	
	private String getPath(UploadsName name) {
		String pathFile = "";
		try {
		
			pathFile = config.get(URL_UPLOADS) + "/" +name.value();
	
		}catch (ParameterNotExist e) {

			e.printStackTrace();

		} 
		return pathFile;
	}
}
