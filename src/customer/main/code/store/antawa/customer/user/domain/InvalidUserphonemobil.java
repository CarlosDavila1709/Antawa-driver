package store.antawa.customer.user.domain;

import store.antawa.shared.domain.DomainError;

public final class InvalidUserphonemobil extends DomainError{

	 public InvalidUserphonemobil(UserPhoneMobile mobile) {
	        super("phone_already_exists", String.format("The mobile <%s> already exists", mobile.value()));
	    }
}
