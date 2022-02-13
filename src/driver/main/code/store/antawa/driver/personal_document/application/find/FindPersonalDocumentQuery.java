package store.antawa.driver.personal_document.application.find;

import store.antawa.shared.domain.bus.query.Query;

public final class FindPersonalDocumentQuery implements Query {

    private final String uid;

    public FindPersonalDocumentQuery(String uid) {
        this.uid = uid;
    }

    public String uid() {
        return uid;
    }
    
    
}
