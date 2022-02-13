package store.antawa.backoffice.solicitud.application;

import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.shared.domain.bus.query.Response;

public final class SolicitudResponse implements Response{

	private final String uid;

	private final String driverUid;
	
	private final String namesDriver;
	
	private final String lastNameDriver;
	
	private final String document;
	
	private final String numberDocument;
	
	private final String status;
	
	private final String imageSoa;
	private final String imageCriminalRecord;
	private final String imageIdentidad;
	private final String imageFaceDriver;
	private final String imageVehiculo;
	private final String dateCreation;
	
	public SolicitudResponse(String uid, 
			String driverUid,
			String namesDriver, 
			String lastNameDriver, 
			String document,
			String numberDocument,
			String status,
			String imageSoa,
			String imageCriminalRecord,
			String imageIdentidad,
			String imageFaceDriver,
			String imageVehiculo,
			String dateCreation) {
		
		this.uid  					= uid;
		this.driverUid				= driverUid;
		this.namesDriver  			= namesDriver;
		this.lastNameDriver 		= lastNameDriver;
		this.document  				= document;
		this.numberDocument 		= numberDocument;
		this.status  				= status;
		this.imageSoa				= imageSoa;
		this.imageCriminalRecord	= imageCriminalRecord;
		this.imageIdentidad			= imageIdentidad;
		this.imageFaceDriver		= imageFaceDriver;
		this.imageVehiculo			= imageVehiculo;
		this.dateCreation			= dateCreation;
	}
	
	public static SolicitudResponse fromAggregate(Solicitud solicitud) {
	
		return new SolicitudResponse(
				solicitud.uid().value(),
				solicitud.driverUid(),
				solicitud.namesDriver(),
				solicitud.lastNameDriver(),
				solicitud.document(),
				solicitud.numberDocument(),
				solicitud.status().value(),
				solicitud.imageSoa(),
				solicitud.imageCriminalRecord(),
				solicitud.imageIdentidad(),
				solicitud.imageFaceDriver(),
				solicitud.imageVehiculo(),
				solicitud.dateCreation().value());
	}
	
	public String uid() {
		return uid;
	}
	public String driverUid() {
		return driverUid;
	}
	public String namesDriver() {
		return namesDriver;
	}
	
	public String lastNameDriver() {
		return lastNameDriver;
	}
	
	public String document() {
		return document;
	}
	
	public String status() {
		return status;
	}
	
	public String numberDocument() {
		return numberDocument;
	}
	
	public String imageSoa() {
		return imageSoa;
	}
	public String imageCriminalRecord() {
		return imageCriminalRecord;
	}
	public String imageIdentidad() {
		return imageIdentidad;
	}
	public String imageFaceDriver() {
		return imageFaceDriver;
	}
	public String imageVehiculo() {
		return imageVehiculo;
	}
	public String dateCreation() {
		return dateCreation;
	}
}
