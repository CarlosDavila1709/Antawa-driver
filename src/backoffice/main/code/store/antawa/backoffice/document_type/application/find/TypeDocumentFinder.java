package store.antawa.backoffice.document_type.application.find;

import store.antawa.backoffice.document_type.application.TypeDocumentResponse;
import store.antawa.backoffice.document_type.domain.DocumentTypeNotExist;
import store.antawa.backoffice.document_type.domain.DocumentTypeRepository;
import store.antawa.backoffice.document_type.domain.DocumentTypeUid;
import store.antawa.shared.domain.Service;

@Service
public final class TypeDocumentFinder {

	private final DocumentTypeRepository repository;
	
	public TypeDocumentFinder(DocumentTypeRepository repository) {
		
		this.repository = repository;
	}
	
	public TypeDocumentResponse find(DocumentTypeUid uid) throws DocumentTypeNotExist{
		return repository.search(uid)
                .map(TypeDocumentResponse::fromAggregate)
                .orElseThrow(() -> new DocumentTypeNotExist(uid));
	}
}
