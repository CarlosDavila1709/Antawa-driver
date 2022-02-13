package store.antawa.driver.driver.domain;

import store.antawa.shared.domain.DomainError;

public final class InvalidDriverExistsUID extends DomainError{

    public InvalidDriverExistsUID(DriverUid uid) {
        super("driver_uid_exists", String.format("The uid <%s> exist", uid.value()));
    }
}
