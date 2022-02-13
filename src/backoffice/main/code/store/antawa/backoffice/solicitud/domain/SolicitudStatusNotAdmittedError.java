package store.antawa.backoffice.solicitud.domain;

import store.antawa.shared.domain.DomainError;

public final class SolicitudStatusNotAdmittedError extends DomainError {

	public SolicitudStatusNotAdmittedError(SolicitudStatus state) {
        super("file_not_admitted", String.format("The state <%s> doesn't exist", state.value()));
	}
}
