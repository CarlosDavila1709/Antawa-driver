package store.antawa.backoffice.solicitud.domain;

import java.util.List;
import java.util.Optional;

import store.antawa.shared.domain.criteria.Criteria;

public interface SolicitudRepository {
	
	void save(Solicitud solicitud);
	
	Optional<Solicitud> search(SolicitudUid uid);
	
	List<Solicitud> matching(Criteria criteria);
	
    List<Solicitud> searchAll();
}
