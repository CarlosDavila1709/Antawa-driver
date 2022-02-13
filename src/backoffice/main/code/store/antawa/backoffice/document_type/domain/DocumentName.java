package store.antawa.backoffice.document_type.domain;

import store.antawa.shared.domain.StringValueObject;

public final class DocumentName extends StringValueObject{


	public DocumentName(String value) {
		super(value);
	}

    public DocumentName() {
        super("");
    }
}
