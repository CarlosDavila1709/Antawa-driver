package store.antawa.driver.personal_document.application.search_all;

import java.util.stream.Collectors;

import store.antawa.driver.personal_document.application.PersonalDocumentResponse;
import store.antawa.driver.personal_document.application.PersonalDocumentsResponse;
import store.antawa.driver.personal_document.domain.PersonalDocumentRepository;
import store.antawa.shared.domain.Service;

@Service
public final class AllPersonalDocumentsSearcher {

	private PersonalDocumentRepository repository;
	
	public AllPersonalDocumentsSearcher(PersonalDocumentRepository repository) {
		
		this.repository = repository;
		
	}
	
	public PersonalDocumentsResponse search() {

        return new PersonalDocumentsResponse(
                repository.searchAll().stream().map(PersonalDocumentResponse::fromAggregate).collect(Collectors.toList())
            );
	}
}
