package store.antawa.driver.personal_document.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.driver.personal_document.domain.PersonalDocument;
import store.antawa.driver.personal_document.domain.PersonalDocumentRepository;
import store.antawa.driver.personal_document.domain.PersonalDocumentUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("driver-transaction_manager")
public class PgSqlPersonalDocumentRepository  extends HibernateRepository<PersonalDocument> implements PersonalDocumentRepository{

    public PgSqlPersonalDocumentRepository(@Qualifier("driver-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, PersonalDocument.class);
    }

	@Override
	public void save(PersonalDocument personalDocument) {
		 persist(personalDocument);
		 
	}

	@Override
	public Optional<? extends PersonalDocument> search(PersonalDocumentUid uid) {
		return byId(uid);
	}

	@Override
	public List<? extends PersonalDocument> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<? extends PersonalDocument> searchAll() {
		
		return all();
	}
}
