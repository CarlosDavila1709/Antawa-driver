package store.antawa.driver.driver.domain;

import store.antawa.shared.domain.DomainError;

public final class DriverNotExist extends DomainError{

	 public DriverNotExist(DriverUid id) {
	        super("driver_not_exist", String.format("The drive <%s> doesn't exist", id.value()));
	    }
}
