package store.antawa.backoffice.uploads.application.to_attach;

import store.antawa.shared.domain.bus.command.Command;

public class AttachFileCommand implements Command{

	private final String ownerUid;
	
	private final String typedocument;
	
	private final byte [] byteArr;
	
	public AttachFileCommand(String ownerUid, String typedocument, byte [] byteArr) {

		this.ownerUid 	 = ownerUid;
		this.byteArr 	 = byteArr;
		this.typedocument= typedocument;
		
	}

	public String ownerUid() {
		return ownerUid;
	}
	public byte [] byteArr(){
		return byteArr;
	}
	public String typedocument() {
		return typedocument;
	}
}
