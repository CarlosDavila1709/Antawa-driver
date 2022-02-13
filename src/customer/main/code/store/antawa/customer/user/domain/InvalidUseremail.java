package store.antawa.customer.user.domain;


import store.antawa.shared.domain.DomainError;

public final class InvalidUseremail extends DomainError{

	 public InvalidUseremail(UserEmail email) {
	        super("email_already_exists", String.format("The email <%s> already exists", email.value()));
	    }
}
