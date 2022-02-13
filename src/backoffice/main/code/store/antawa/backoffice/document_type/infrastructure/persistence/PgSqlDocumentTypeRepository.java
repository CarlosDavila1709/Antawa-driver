package store.antawa.backoffice.document_type.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import store.antawa.backoffice.document_type.domain.DocumentType;
import store.antawa.backoffice.document_type.domain.DocumentTypeRepository;
import store.antawa.backoffice.document_type.domain.DocumentTypeUid;

import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.infrastructure.hibernate.HibernateRepository;

@Service
@Transactional("backoffice-transaction_manager")
public class PgSqlDocumentTypeRepository extends HibernateRepository<DocumentType> implements DocumentTypeRepository{


	public PgSqlDocumentTypeRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
		
		 super(sessionFactory, DocumentType.class);
	}
	
	@Override
	public void save(DocumentType type) {
		 persist(type);
		
	}

	@Override
	public Optional<DocumentType> search(DocumentTypeUid uid) {
		return byId(uid);
	}

	@Override
	public List<DocumentType> matching(Criteria criteria) {
		 return byCriteria(criteria);
	}

	@Override
	public List<DocumentType> searchAll() {
		
		return all();
	}
}
