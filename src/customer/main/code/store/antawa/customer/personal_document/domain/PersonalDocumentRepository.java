package store.antawa.customer.personal_document.domain;

import java.util.List;
import java.util.Optional;
import store.antawa.shared.domain.criteria.Criteria;

public interface PersonalDocumentRepository {

	void save(PersonalDocument personalDocument);
	
	Optional<? extends PersonalDocument> search(PersonalDocumentUid uid);
	
	List<? extends PersonalDocument> matching(Criteria criteria);
	
    List<? extends PersonalDocument> searchAll();
}
