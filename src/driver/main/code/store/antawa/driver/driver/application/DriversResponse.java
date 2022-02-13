package store.antawa.driver.driver.application;

import java.util.List;

import store.antawa.shared.domain.bus.query.Response;

public final class DriversResponse implements Response {

	private final List<DriverResponse> drivers;

	public DriversResponse(List<DriverResponse> drivers) {
		this.drivers = drivers;
	}

	public List<DriverResponse> drivers() {
		return drivers;
	}
}
