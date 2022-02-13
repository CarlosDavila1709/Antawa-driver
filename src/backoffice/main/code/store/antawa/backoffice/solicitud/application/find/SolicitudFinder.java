package store.antawa.backoffice.solicitud.application.find;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.backoffice.solicitud.domain.SolicitudNotExist;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.shared.domain.Service;

@Service
public final class SolicitudFinder {

	private final SolicitudRepository repository;
	
	public SolicitudFinder(SolicitudRepository repository) {
		
		this.repository = repository;
	}
	
	public SolicitudResponse find(SolicitudUid uid) throws SolicitudNotExist{
		return repository.search(uid)
                .map(SolicitudResponse::fromAggregate)
                .orElseThrow(() -> new SolicitudNotExist(uid));
	}
}
