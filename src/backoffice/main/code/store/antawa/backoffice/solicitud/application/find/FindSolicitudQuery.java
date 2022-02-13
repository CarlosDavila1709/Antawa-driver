package store.antawa.backoffice.solicitud.application.find;

import store.antawa.shared.domain.bus.query.Query;

public final class FindSolicitudQuery implements Query{

    private final String uid;
    
    public FindSolicitudQuery(String uid) {
    	this.uid = uid;
    }

    public String uid() {
        return uid;
    }
}
