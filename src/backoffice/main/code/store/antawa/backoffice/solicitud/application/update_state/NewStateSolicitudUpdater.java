package store.antawa.backoffice.solicitud.application.update_state;

import java.util.Optional;

import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.backoffice.solicitud.domain.SolicitudStatus;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.shared.domain.Service;

@Service
public final class NewStateSolicitudUpdater {

	private final SolicitudRepository repository;
	
	public NewStateSolicitudUpdater(SolicitudRepository repository) {
		this.repository = repository;
	}
	
	public void update(SolicitudUid uid, SolicitudStatus newState, String observation) {
		
		newState.validateState();
		
		Optional<Solicitud> solicitud = repository.search(uid);
		
		
		if( solicitud.isPresent() ) {
			
			Solicitud solicitudBD = solicitud.get();
			
			solicitudBD.updateState(newState);
			solicitudBD.updateObservation(observation);
			repository.save(solicitudBD);
		}
		
	}
}
