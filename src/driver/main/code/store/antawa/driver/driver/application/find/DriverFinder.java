package store.antawa.driver.driver.application.find;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.domain.DriverNotExist;
import store.antawa.driver.driver.domain.DriverRepository;
import store.antawa.driver.driver.domain.DriverUid;
import store.antawa.shared.domain.Service;

@Service
public final class DriverFinder{

	private final DriverRepository repository;
	
	public DriverFinder(DriverRepository repository) {
		
		this.repository = repository;
	}
	
	public DriverResponse find(DriverUid uid) throws DriverNotExist{
		return repository.search(uid)
                .map(DriverResponse::fromAggregate)
                .orElseThrow(() -> new DriverNotExist(uid));
	}
}
