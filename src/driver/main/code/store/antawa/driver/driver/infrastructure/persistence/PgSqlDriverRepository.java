package store.antawa.driver.driver.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.driver.driver.domain.Driver;
import store.antawa.driver.driver.domain.DriverRepository;
import store.antawa.driver.driver.domain.DriverUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("driver-transaction_manager")
public class PgSqlDriverRepository extends HibernateRepository<Driver> implements DriverRepository {

    public PgSqlDriverRepository(@Qualifier("driver-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Driver.class);
    }

	@Override
	public void save(Driver driver) {
		 persist(driver);
		 
	}

	@Override
	public Optional<Driver> search(DriverUid uid) {
		return byId(uid);
	}

	@Override
	public List<Driver> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<Driver> searchAll() {
		
		return all();
	}


}
