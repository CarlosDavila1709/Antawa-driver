package store.antawa.driver.driver.domain;

public final class InvalidDriverCredentials extends RuntimeException {

	public InvalidDriverCredentials(DriverEmail driverEmail) {
        super(String.format("The credentials for <%s> are invalid", driverEmail.value()));
    }
}
