package store.antawa.customer.user.domain;

import store.antawa.shared.domain.DomainError;

public final class UserNotExist  extends DomainError{

	 public UserNotExist(UserEmail email) {
	        super("user_not_exists", String.format("The user <%s> not exists", email.value()));
	    }
}
