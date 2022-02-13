package store.antawa.backoffice.solicitud.domain;

import store.antawa.shared.domain.DomainError;

public class SolicitudNotExist extends DomainError  {

	public SolicitudNotExist(SolicitudUid uid) {
        super("solicitud_not_exist", String.format("The solicitud <%s> doesn't exist", uid.value()));
    }
}
