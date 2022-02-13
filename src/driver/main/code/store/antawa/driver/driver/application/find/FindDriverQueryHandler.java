package store.antawa.driver.driver.application.find;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.domain.DriverUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class FindDriverQueryHandler implements QueryHandler<FindDriverQuery, DriverResponse>{

	private final DriverFinder finder;
	
	public FindDriverQueryHandler(DriverFinder finder) {
		
		this.finder = finder;
	}
	@Override
	public DriverResponse handle(FindDriverQuery query) {
		
		return finder.find(new DriverUid(query.uid()));
	}
}
