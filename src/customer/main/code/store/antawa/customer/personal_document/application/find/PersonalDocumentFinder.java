package store.antawa.customer.personal_document.application.find;

import store.antawa.customer.personal_document.application.PersonalDocumentResponse;
import store.antawa.customer.personal_document.domain.PersonalDocumentNotExist;
import store.antawa.customer.personal_document.domain.PersonalDocumentRepository;
import store.antawa.customer.personal_document.domain.PersonalDocumentUid;
import store.antawa.shared.domain.Service;

@Service
public final class PersonalDocumentFinder {

	private final PersonalDocumentRepository repository;
	
	public PersonalDocumentFinder(PersonalDocumentRepository repository) {
		
		this.repository = repository;
	}
	
    public PersonalDocumentResponse find(PersonalDocumentUid uid) throws PersonalDocumentNotExist {
        return repository.search(uid)
                         .map(PersonalDocumentResponse::fromAggregate)
                         .orElseThrow(() -> new PersonalDocumentNotExist(uid));
    }
}
