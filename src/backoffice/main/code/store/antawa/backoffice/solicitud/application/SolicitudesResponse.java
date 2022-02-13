package store.antawa.backoffice.solicitud.application;

import java.util.List;

import store.antawa.shared.domain.bus.query.Response;

public class SolicitudesResponse implements Response{

	private final List<SolicitudResponse> solicitudes;
	
	public SolicitudesResponse(List<SolicitudResponse> solicitudes) {
		
		this.solicitudes = solicitudes;
	}
	
	public List<SolicitudResponse> solicitudes(){
		return solicitudes;
	}
}
