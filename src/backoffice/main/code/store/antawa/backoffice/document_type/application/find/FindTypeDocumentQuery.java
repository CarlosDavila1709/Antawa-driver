package store.antawa.backoffice.document_type.application.find;

import store.antawa.shared.domain.bus.query.Query;

public final class FindTypeDocumentQuery implements Query {

    private final String uid;

    public FindTypeDocumentQuery(String uid) {
        this.uid = uid;
    }

    public String uid() {
        return uid;
    }
}
