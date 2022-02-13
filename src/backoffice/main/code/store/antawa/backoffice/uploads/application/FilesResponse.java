package store.antawa.backoffice.uploads.application;

import java.util.List;

import store.antawa.shared.domain.bus.query.Response;

public final class FilesResponse implements Response{

	private final List<FileResponse> files;
	
	public FilesResponse(List<FileResponse> files) {
        this.files = files;
    }

    public List<FileResponse> files() {
        return files;
    }
}
