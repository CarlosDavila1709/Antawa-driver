package store.antawa.backoffice.solicitud.application.search_all;

import store.antawa.backoffice.solicitud.application.SolicitudesResponse;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllSolicitudQueryHandler implements QueryHandler<SearchAllSolicitudQuery, SolicitudesResponse>{

	private final AllSolicitudSearch searcher;
	
	public SearchAllSolicitudQueryHandler(AllSolicitudSearch searcher) {
		this.searcher = searcher;
	}
	
	@Override
	public SolicitudesResponse handle(SearchAllSolicitudQuery query) {
		
		return searcher.search();
	}

	
}
