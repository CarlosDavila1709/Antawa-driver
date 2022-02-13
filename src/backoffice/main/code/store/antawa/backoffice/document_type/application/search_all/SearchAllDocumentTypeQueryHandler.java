package store.antawa.backoffice.document_type.application.search_all;

import store.antawa.backoffice.document_type.application.TypeDocumentsResponse;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllDocumentTypeQueryHandler implements QueryHandler<SearchAllDocumentTypeQuery, TypeDocumentsResponse>{

	private final AllDocumentTypeSearch search;
	
	public SearchAllDocumentTypeQueryHandler(AllDocumentTypeSearch search) {
		
		this.search = search;
	}
	
	@Override
	public TypeDocumentsResponse handle(SearchAllDocumentTypeQuery query) {
		
		return search.search();
	}

}
