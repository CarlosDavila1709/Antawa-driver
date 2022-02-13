package store.antawa.backoffice.user.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.backoffice.user.domain.User;
import store.antawa.backoffice.user.domain.UserRepository;
import store.antawa.backoffice.user.domain.UserUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlUserBackofficeRepository  extends HibernateRepository<User> implements UserRepository{

    public PgSqlUserBackofficeRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
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
