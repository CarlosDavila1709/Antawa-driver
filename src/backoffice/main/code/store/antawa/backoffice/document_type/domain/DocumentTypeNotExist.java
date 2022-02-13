package store.antawa.backoffice.document_type.domain;

import store.antawa.shared.domain.DomainError;

public final class DocumentTypeNotExist extends DomainError{

	public DocumentTypeNotExist(DocumentTypeUid id) {
		super("type_document_not_exist", String.format("The type document <%s> doesn't exist", id.value()));
	}
}
