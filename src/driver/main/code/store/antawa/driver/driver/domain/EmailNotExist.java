package store.antawa.driver.driver.domain;

import store.antawa.shared.domain.DomainError;

public final class EmailNotExist extends DomainError{

	 public EmailNotExist(DriverEmail email) {
	        super("email_not_exist", String.format("The email <%s> doesn't exist", email.value()));
	    }
}
