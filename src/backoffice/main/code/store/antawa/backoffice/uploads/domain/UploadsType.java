package store.antawa.backoffice.uploads.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UploadsType extends StringValueObject {

	private static String TYPE_SOLICITUD_IDENTIDAD   		= "solicitud-identidad";
	private static String TYPE_SOLICITUD_SOA   				= "solicitud-soa";
	private static String TYPE_SOLICITUD_RECORD_CRIMINAL   	= "solicitud-criminal";
	private static String TYPE_SOLICITUD_VEHICULO   		= "solicitud-vehiculo";
	private static String TYPE_SOLICITUD_FACE_DRIVER   		= "solicitud-face";
	private static String TYPE_AVATAR_DRIVER 				= "avatar-driver";
	private static String TYPE_AVATAR_CUSTOMER 				= "avatar-customer";
	
	public UploadsType(String value) {
		
		super(value);
		
	}

	
	public UploadsType() {
		super(null);
	}
	
	public static String typeSolicitudIdentidad() {
		return TYPE_SOLICITUD_IDENTIDAD;
	}
	public static String typeSolicitudSoa() {
		return TYPE_SOLICITUD_SOA;
	}
	public static String typeSolicitudRecordCriminal() {
		return TYPE_SOLICITUD_RECORD_CRIMINAL;
	}
	public static String typeSolicitudVehiculo() {
		return TYPE_SOLICITUD_VEHICULO;
	}
	public static String typeSolicitudFace() {
		return TYPE_SOLICITUD_FACE_DRIVER;
	}
	public static String typeAvatarDriver() {
		return TYPE_AVATAR_DRIVER;
	}
	public static String typeAvatarCustomer() {
		return TYPE_AVATAR_CUSTOMER;
	}
	
}
