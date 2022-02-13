package store.antawa.backoffice.solicitud.application.find;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class FindSolicitudQueryHandler implements QueryHandler<FindSolicitudQuery, SolicitudResponse>{

	private final SolicitudFinder finder;
	
	public FindSolicitudQueryHandler(SolicitudFinder finder) {
		
		this.finder = finder;
	}
	
	@Override
	public SolicitudResponse handle(FindSolicitudQuery query) {
		
		return finder.find(new SolicitudUid(query.uid()));
	}

	 
}
