package store.antawa.backoffice.solicitud.domain;

import store.antawa.shared.domain.DomainError;

public class SolicitudDriverNotExist extends DomainError {

	public SolicitudDriverNotExist(String uidDriver) {
        super("solicitud_driver_not_exist", String.format("The solicitud <%s> doesn't exist", uidDriver));
    }
}
