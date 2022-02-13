package store.antawa.backoffice.uploads.application;

import store.antawa.backoffice.uploads.domain.Uploads;
import store.antawa.shared.domain.bus.query.Response;

public final class FileResponse implements Response{

	private String name;
	private byte[] file;
	private String path;
	
	public FileResponse(String name, byte[] file, String path) {
		this.name 	= name;
		this.file 	= file;
		this.path   = path;
	}
	
	public static FileResponse fromAggregate(Uploads uploads) {
		
		return new FileResponse(uploads.name().value(), uploads.file().value(), uploads.path().value());
		
	}
	
	public String name() {
		return name;
	}
	
	public byte[] file() {
		return file;
	}
	
	public String path() {
		return path;
	}
}
