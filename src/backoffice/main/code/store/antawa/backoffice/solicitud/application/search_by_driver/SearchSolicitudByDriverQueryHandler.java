package store.antawa.backoffice.solicitud.application.search_by_driver;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchSolicitudByDriverQueryHandler implements QueryHandler<SearchSolicitudByDriverQuery,SolicitudResponse>{

	private final SolicitudByDriverSearch searcher;
	
	public SearchSolicitudByDriverQueryHandler(SolicitudByDriverSearch searcher) {
		
		this.searcher = searcher;
	}
	
	@Override
	public SolicitudResponse handle(SearchSolicitudByDriverQuery query) {
		
		return searcher.search(query.uidDriver());
	}
}
