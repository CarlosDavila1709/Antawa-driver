package store.antawa.backoffice.document_type.application.find;

import store.antawa.backoffice.document_type.application.TypeDocumentResponse;
import store.antawa.backoffice.document_type.domain.DocumentTypeUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class FindTypeDocumentQueryHandler implements QueryHandler<FindTypeDocumentQuery, TypeDocumentResponse>{

	private final TypeDocumentFinder finder;
	
	public FindTypeDocumentQueryHandler(TypeDocumentFinder finder) {
		
		this.finder = finder;
	}
	
	@Override
	public TypeDocumentResponse handle(FindTypeDocumentQuery query) {
		
		return finder.find(new DocumentTypeUid(query.uid()));
	}

}
