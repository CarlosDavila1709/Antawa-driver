package store.antawa.driver.personal_document.domain.passport;

import store.antawa.driver.personal_document.domain.PersonalDocument;
import store.antawa.driver.personal_document.domain.PersonalDocumentName;
import store.antawa.driver.personal_document.domain.PersonalDocumentUid;

public final class Passport extends PersonalDocument {

	public Passport(PersonalDocumentUid uid, PersonalDocumentName name) {
		
		super(uid, name);
		
	}

	private Passport() {
		super(null, null);
	}
	
}
