package store.antawa.backoffice.uploads.application.load_file;

import store.antawa.backoffice.uploads.application.FileResponse;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class FindFileByNameQueryHandler implements QueryHandler<FindFileByNameQuery, FileResponse> {

	private final FileByNameSeacher finder;

	
	public FindFileByNameQueryHandler(FileByNameSeacher finder) {
	
		this.finder = finder;
	}
	
	@Override
	public FileResponse handle(FindFileByNameQuery query) {
		
		return finder.find(new UploadsName(query.name())); 
	}
}
