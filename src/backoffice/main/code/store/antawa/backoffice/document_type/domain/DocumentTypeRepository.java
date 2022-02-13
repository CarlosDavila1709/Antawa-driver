package store.antawa.backoffice.document_type.domain;

import java.util.List;
import java.util.Optional;


import store.antawa.shared.domain.criteria.Criteria;

public interface DocumentTypeRepository {

	void save(DocumentType driver);
	
	Optional<DocumentType> search(DocumentTypeUid uid);
	
	List<DocumentType> matching(Criteria criteria);
	
    List<DocumentType> searchAll();
}
