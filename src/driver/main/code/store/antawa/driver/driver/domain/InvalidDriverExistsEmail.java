package store.antawa.driver.driver.domain;

import store.antawa.shared.domain.DomainError;

public final class InvalidDriverExistsEmail extends DomainError{

    public InvalidDriverExistsEmail(DriverEmail driverEmail) {
        super("driver_email_exists", String.format("The email <%s> exist", driverEmail.value()));
    }
}
