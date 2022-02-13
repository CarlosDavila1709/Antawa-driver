package store.antawa.customer.user.domain;

import store.antawa.shared.domain.DomainError;

public final class InvalidUserCredentials  extends DomainError{

	 public InvalidUserCredentials(UserEmail email) {
	        super("user_credentials_invalid", String.format("The credentials <%s> invalidate", email.value()));
	    }
}
