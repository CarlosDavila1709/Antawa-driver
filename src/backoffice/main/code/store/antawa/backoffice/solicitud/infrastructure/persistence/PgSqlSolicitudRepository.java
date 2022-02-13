package store.antawa.backoffice.solicitud.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlSolicitudRepository extends HibernateRepository<Solicitud> implements SolicitudRepository{
   
	public PgSqlSolicitudRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Solicitud.class);
    }

	@Override
	public void save(Solicitud solicitud) {
		 persist(solicitud);
		 
	}

	@Override
	public Optional<Solicitud> search(SolicitudUid uid) {
		return byId(uid);
	}

	@Override
	public List<Solicitud> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<Solicitud> searchAll() {
		
		return all();
	}
}
