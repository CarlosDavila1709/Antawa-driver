package store.antawa.backoffice.solicitud.domain;

import java.util.Objects;
import store.antawa.shared.domain.AggregateRoot;

public final class Solicitud extends AggregateRoot{

	private final SolicitudUid uid;
	
	private final String driverUid;
	
	private final String namesDriver;
	
	private final String lastNameDriver;
	
	private final String document;
	
	private final String numberDocument;
	
	private String observation;
	
	private String imageSoa;
	
	private String imageCriminalRecord;
	
	private String imageVehiculo;
	
	private String imageFaceDriver;
	
	private String imageIdentidad;
	
	private SolicitudStatus status;

	private SolicitudDateCreation dateCreation;
	
	public Solicitud(SolicitudUid uid, 
			String driverUid, 
			String namesDriver, 
			String lastNameDriver, 
			String document, 
			String numberDocument, 
			SolicitudStatus status,
			String imageSoa,
			String imageCriminalRecord,
			String imageVehiculo,
			String imageFaceDriver,
			String imageIdentidad,
			String observation,
			SolicitudDateCreation dateCreation) {
		
    	this.uid 			= uid;
    	this.driverUid 		= driverUid;
    	this.namesDriver 	= namesDriver;
    	this.document 		= document;
    	this.numberDocument = numberDocument;
    	this.lastNameDriver = lastNameDriver;
    	this.status 		= status;
    	this.imageSoa		= imageSoa;
    	this.imageCriminalRecord = imageCriminalRecord;
    	this.imageVehiculo		 = imageVehiculo;
    	this.imageFaceDriver	 = imageFaceDriver;
    	this.imageIdentidad		 = imageIdentidad;
    	this.observation		 = observation;
    	this.dateCreation		 = dateCreation;
    	
	}
	
	private Solicitud() {
		
    	this.uid 			= null;
    	this.driverUid		= null;
    	this.namesDriver 	= null;
    	this.document 		= null;
    	this.numberDocument = null;
    	this.lastNameDriver = null;
    	this.status		    = null;
    	
    	this.imageSoa		    	= null;
    	this.imageCriminalRecord	= null;
    	this.imageVehiculo		    = null;
    	this.imageFaceDriver		= null;
    	this.imageIdentidad			= null;
    	this.observation			= null;
    	this.dateCreation			= null;
	}
	
	public static Solicitud create(SolicitudUid uid, 
			String driverUid, 
			String namesDriver, 
			String lastNameDriver, 
			String document, 
			String numberDocument, 
			SolicitudStatus status,
			String imageSoa,
			String imageCriminalRecord,
			String imageVehiculo,
			String imageFaceDriver,
			String imageIdentidad,
			String observation,
			SolicitudDateCreation dateCreation)
	{
		
		Solicitud solicitud = new Solicitud(uid, 
				driverUid, 
				namesDriver, 
				lastNameDriver, 
				document, 
				numberDocument, 
				status,
				imageSoa,
				imageCriminalRecord,
				imageVehiculo,
				imageFaceDriver,
				imageIdentidad,
				observation,
				dateCreation);
		
		return solicitud;
	}
			
	public SolicitudUid uid() {
		
		return uid;
	}
	public String driverUid() {
		
		return driverUid;
	}
	public String namesDriver() {
		
		return namesDriver;
	}
	public String document() {
		
		return document;
	}	
	public String numberDocument() {
		
		return numberDocument;
	}
	public String lastNameDriver() {
		
		return lastNameDriver;
	}
	public SolicitudStatus status() {
		return status;
	}
	public String imageSoa() {
		return imageSoa;
	}
	public String imageCriminalRecord() {
		return imageCriminalRecord;
	}
	public String imageVehiculo() {
		return imageVehiculo;
	}
	public String imageFaceDriver() {
		return imageFaceDriver;
	}
	public String imageIdentidad() {
		return imageIdentidad;
	}
	public String observation() {
		return observation;
	}
	public SolicitudDateCreation dateCreation() {
		return dateCreation;
	}
	public void updateImageSoa(String imageSoa) {
		this.imageSoa = imageSoa;
	}
	public void updateImageCriminalRecord(String imageCriminalRecord) {
		this.imageCriminalRecord = imageCriminalRecord;
	}
	public void updateImageVehiculo(String imageVehiculo) {
		this.imageVehiculo = imageVehiculo;
	}
	public void updateiImageFaceDriver(String imageFaceDriver) {
		this.imageFaceDriver = imageFaceDriver;
	}
	public void updateiImageIdentidad(String imageIdentidad) {
		this.imageIdentidad = imageIdentidad;
	}
	public void updateState(SolicitudStatus status) {
		this.status = status;
	}
	public void updateObservation(String observation) {
		this.observation = observation;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Solicitud solicitud = (Solicitud) o;
        return uid.equals(solicitud.uid) &&
        		driverUid.endsWith(solicitud.driverUid) &&
        		namesDriver.equals(solicitud.namesDriver) &&
        		lastNameDriver.equals(solicitud.lastNameDriver) &&
        		document.equals(solicitud.document) &&
        		numberDocument.equals(solicitud.numberDocument) &&
        		status.equals(solicitud.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash( uid,
        		driverUid,
        		namesDriver,
        		lastNameDriver,
        		document,
        		numberDocument,
        		status);
    }
	
}
