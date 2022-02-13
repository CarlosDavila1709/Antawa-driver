package store.antawa.backoffice.solicitud.application.search_all;

import java.util.stream.Collectors;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.backoffice.solicitud.application.SolicitudesResponse;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.shared.domain.Service;

@Service
public final class AllSolicitudSearch {

	private final SolicitudRepository repository;
	
	public AllSolicitudSearch(SolicitudRepository repository) {
		
		this.repository = repository;
	}
	
	public SolicitudesResponse search() {
		return new SolicitudesResponse(
				repository.searchAll().stream().map(SolicitudResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
