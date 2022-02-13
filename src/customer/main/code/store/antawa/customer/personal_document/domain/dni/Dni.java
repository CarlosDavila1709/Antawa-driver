package store.antawa.customer.personal_document.domain.dni;

import store.antawa.customer.personal_document.domain.PersonalDocument;
import store.antawa.customer.personal_document.domain.PersonalDocumentName;
import store.antawa.customer.personal_document.domain.PersonalDocumentUid;

public final class Dni extends PersonalDocument{

	public Dni(PersonalDocumentUid uid, PersonalDocumentName name) {
		
		super(uid, name);
		
	}

	private Dni() {
		super(null, null);
	}
}
