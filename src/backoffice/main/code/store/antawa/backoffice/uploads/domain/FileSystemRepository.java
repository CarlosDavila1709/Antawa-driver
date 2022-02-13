package store.antawa.backoffice.uploads.domain;

import java.util.Optional;

public interface FileSystemRepository {

	public void save(Uploads uploads);
	
	public Optional<Uploads> search(UploadsName name);
}
