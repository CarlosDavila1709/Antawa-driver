package store.antawa.backoffice.solicitud.domain;

import store.antawa.shared.domain.StringValueObject;

public final class SolicitudStatus extends StringValueObject{

	private static String received = "received";
	private static String rejected = "rejected";
	private static String approved = "approved";
	
	public SolicitudStatus(String value) {
		
		super(value);
		
	}
	public SolicitudStatus() {
		super("");
	}
	
	public static String received() {
		return received;
	}
	public static String rejected() {
		return rejected;
	}
	public static String approved() {
		return approved;
	}
	
	public void validateState() {
		
		if(	!SolicitudStatus.received().equals(this.value())
			&&	!SolicitudStatus.rejected().equals(this.value())
			&&	!SolicitudStatus.approved().equals(this.value()) ) {
			
			throw new SolicitudStatusNotAdmittedError(this);
		}
	}
}
