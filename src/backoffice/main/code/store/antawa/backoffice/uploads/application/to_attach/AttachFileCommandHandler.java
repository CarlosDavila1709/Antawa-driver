package store.antawa.backoffice.uploads.application.to_attach;

import store.antawa.backoffice.uploads.application.to_attach.AttachFileCommand;
import store.antawa.backoffice.uploads.domain.OwnerUid;
import store.antawa.backoffice.uploads.domain.UploadsFile;
import store.antawa.backoffice.uploads.domain.UploadsType;
import store.antawa.backoffice.uploads.application.to_attach.FileAttached;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public final class AttachFileCommandHandler  implements CommandHandler<AttachFileCommand> {

	private final FileAttached attached;
	
	public AttachFileCommandHandler(FileAttached attached) {
		
		this.attached = attached;
	}
	
	@Override
	public void handle(AttachFileCommand command) {

		OwnerUid ownerUid 		= new OwnerUid(command.ownerUid());
		UploadsFile file 		= new UploadsFile(command.byteArr());		
		UploadsType uploadsType = new UploadsType(command.typedocument());
		
		attached.attached( ownerUid, uploadsType, file);
	}
}
