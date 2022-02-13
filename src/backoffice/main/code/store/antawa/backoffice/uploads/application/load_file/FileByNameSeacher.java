package store.antawa.backoffice.uploads.application.load_file;

import store.antawa.backoffice.uploads.application.FileResponse;
import store.antawa.backoffice.uploads.domain.FileNotExist;
import store.antawa.backoffice.uploads.domain.FileSystemRepository;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.shared.domain.Service;

@Service
public final class FileByNameSeacher {

	private final FileSystemRepository  repository;
	
	public FileByNameSeacher(FileSystemRepository repository) {
		
		this.repository = repository;

	}
	
	public FileResponse find(UploadsName name) throws FileNotExist {


		return repository.search( name )
                .map(FileResponse::fromAggregate)
                .orElseThrow(() -> new FileNotExist( name ) );
	}
}
