package store.antawa.driver.driver.domain;

import java.util.List;
import java.util.Optional;

import store.antawa.shared.domain.criteria.Criteria;

public interface DriverRepository {

	void save(Driver driver);
	
	Optional<Driver> search(DriverUid uid);
	
	List<Driver> matching(Criteria criteria);
	
    List<Driver> searchAll();
}
