package store.antawa.backoffice.uploads.domain;

import store.antawa.shared.domain.DomainError;

public final class FileNotExist extends DomainError{

	public FileNotExist(UploadsName name) {
        super("file_not_exist", String.format("The file <%s> doesn't exist", name.value()));
	}
	
}
