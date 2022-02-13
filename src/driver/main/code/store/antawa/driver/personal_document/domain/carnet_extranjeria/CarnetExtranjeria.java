package store.antawa.driver.personal_document.domain.carnet_extranjeria;

import store.antawa.driver.personal_document.domain.PersonalDocument;
import store.antawa.driver.personal_document.domain.PersonalDocumentName;
import store.antawa.driver.personal_document.domain.PersonalDocumentUid;

public final class CarnetExtranjeria extends PersonalDocument{

	public CarnetExtranjeria(PersonalDocumentUid uid, PersonalDocumentName name) {
		
		super(uid, name);
		
	}

	private CarnetExtranjeria() {
		super(null, null);
	}
	
}
