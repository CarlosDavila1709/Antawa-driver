package store.antawa.backoffice.uploads.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.backoffice.uploads.domain.Uploads;
import store.antawa.backoffice.uploads.domain.UploadsRepository;
import store.antawa.backoffice.uploads.domain.UploadsUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlUploadsRepository extends HibernateRepository<Uploads> implements UploadsRepository{

    public PgSqlUploadsRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Uploads.class);
    }
    
	@Override
	public void save(Uploads uploads) {
		 persist(uploads);
	}

	@Override
	public Optional<Uploads> search(UploadsUid uid) {
		return byId(uid);
	}

	@Override
	public List<Uploads> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<Uploads> searchAll() {
		
		return all();
	}


}
