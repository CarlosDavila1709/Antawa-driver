package store.antawa.backoffice.uploads.domain;

import store.antawa.shared.domain.BytesValueObject;

public final class UploadsFile extends BytesValueObject{
	
	public UploadsFile() {
		super(null);
	}
	public UploadsFile(byte[] value) {
		super(value);
	}
}
