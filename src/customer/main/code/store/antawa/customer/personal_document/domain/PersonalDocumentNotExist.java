package store.antawa.customer.personal_document.domain;

import store.antawa.shared.domain.DomainError;

public final class PersonalDocumentNotExist extends DomainError{

    public PersonalDocumentNotExist(PersonalDocumentUid uid) {
        super("personal_document_not_exist", String.format("The personal document <%s> doesn't exist", uid.value()));
    }
}
