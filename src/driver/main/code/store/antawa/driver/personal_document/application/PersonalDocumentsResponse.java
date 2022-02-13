package store.antawa.driver.personal_document.application;

import java.util.List;
import store.antawa.shared.domain.bus.query.Response;

public final class PersonalDocumentsResponse implements Response{

	private final List<PersonalDocumentResponse> documents;
	
	public PersonalDocumentsResponse(List<PersonalDocumentResponse> documents) {
		this.documents = documents;
	}

	public List<PersonalDocumentResponse> documents() {
		return documents;
	}

}
