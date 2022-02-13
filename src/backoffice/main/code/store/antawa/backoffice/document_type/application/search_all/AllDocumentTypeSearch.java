package store.antawa.backoffice.document_type.application.search_all;

import java.util.stream.Collectors;

import store.antawa.backoffice.document_type.application.TypeDocumentResponse;
import store.antawa.backoffice.document_type.application.TypeDocumentsResponse;
import store.antawa.backoffice.document_type.domain.DocumentTypeRepository;
import store.antawa.shared.domain.Service;

@Service
public final class AllDocumentTypeSearch {

	private final DocumentTypeRepository repository;
	
	public AllDocumentTypeSearch(DocumentTypeRepository repository) {
		
		this.repository = repository;
	}
	
	 public TypeDocumentsResponse search() {
			
		 return new TypeDocumentsResponse(
					repository.searchAll().stream().map(TypeDocumentResponse::fromAggregate).collect(Collectors.toList())
			);
	 }
}
