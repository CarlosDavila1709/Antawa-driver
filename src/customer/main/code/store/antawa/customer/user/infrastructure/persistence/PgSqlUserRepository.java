package store.antawa.customer.user.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.customer.user.domain.User;
import store.antawa.customer.user.domain.UserRepository;
import store.antawa.customer.user.domain.UserUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("customer-transaction_manager")
public class PgSqlUserRepository extends HibernateRepository<User> implements UserRepository{

    public PgSqlUserRepository(@Qualifier("customer-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

	@Override
	public void save(User user) {
		 persist(user);
		 
	}

	@Override
	public Optional<User> search(UserUid uid) {
		return byId(uid);
	}

	@Override
	public List<User> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<User> searchAll() {
		
		return all();
	}
}
