package store.antawa.backoffice.solicitud.application.search_by_driver;


import store.antawa.shared.domain.bus.query.Query;

public final class SearchSolicitudByDriverQuery  implements Query {

    private final String uidDriver;
    
    public SearchSolicitudByDriverQuery(String uidDriver) {
    	
    	this.uidDriver = uidDriver;
    }

    public String uidDriver() {
        return uidDriver;
    }
}
