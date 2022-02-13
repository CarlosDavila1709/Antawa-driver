package store.antawa.backoffice.solicitud.application.to_attach;

import java.util.Optional;

import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.backoffice.solicitud.domain.SolicitudUid;
import store.antawa.backoffice.uploads.domain.OwnerUid;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.backoffice.uploads.domain.UploadsType;
import store.antawa.shared.domain.Service;

@Service
public final class DocumentAttached {

	private final SolicitudRepository repository;
	
	
	public DocumentAttached(SolicitudRepository repository) {
		
		this.repository = repository;
	}
	
	public void attached(OwnerUid ownerUid, UploadsType type, UploadsName name) {
		
		Optional<Solicitud> solicitudBD = repository.search(new SolicitudUid(ownerUid.value()));
		
		if(solicitudBD.isPresent()) {
			
			if( UploadsType.typeSolicitudIdentidad().equals(type.value()) ){
				solicitudBD.get().updateiImageIdentidad(name.value());
			}else if( UploadsType.typeSolicitudSoa().equals(type.value()) ){
				solicitudBD.get().updateImageSoa(name.value());
			}else if( UploadsType.typeSolicitudRecordCriminal().equals(type.value()) ){
				solicitudBD.get().updateImageCriminalRecord(name.value());
			}else if( UploadsType.typeSolicitudVehiculo().equals(type.value()) ){
				solicitudBD.get().updateImageVehiculo(name.value());
			}else if( UploadsType.typeSolicitudFace().equals(type.value()) ){
				solicitudBD.get().updateiImageFaceDriver(name.value());
			}
			
			
			repository.save(solicitudBD.get());
		}

	}
}
