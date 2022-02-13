package store.antawa.customer.personal_document.application.find;

import store.antawa.customer.personal_document.application.PersonalDocumentResponse;
import store.antawa.customer.personal_document.domain.PersonalDocumentNotExist;
import store.antawa.customer.personal_document.domain.PersonalDocumentUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class FindPersonalDocumentQueryHandler implements QueryHandler<FindPersonalDocumentQuery, PersonalDocumentResponse>{

    private final PersonalDocumentFinder finder;

    public FindPersonalDocumentQueryHandler(PersonalDocumentFinder finder) {
        this.finder = finder;
    }

    @Override
    public PersonalDocumentResponse handle(FindPersonalDocumentQuery query) throws PersonalDocumentNotExist {
        return finder.find(new PersonalDocumentUid(query.uid()));
    }
}
