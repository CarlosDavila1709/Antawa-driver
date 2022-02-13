package store.antawa.driver.driver.application;

import store.antawa.driver.driver.domain.Driver;
import store.antawa.shared.domain.bus.query.Response;

public final class DriverResponse implements Response {

	private final String uid;
	private final String names;
	private final String lastName;
	private final String phoneMobile;
	private final String email;
	private final String password;
	private final String typeDocumentPersonal;
	private final String numberDocumentPersonal;

	public DriverResponse(String uid, 
			String names, 
			String lastName,
			String phoneMobile, 
			String email, 
			String password, 
			String typeDocumentPersonal, 
			String numberDocumentPersonal) {
		
	        this.uid        			= uid;
	        this.names      			= names;
	        this.lastName 				= lastName;
	        this.phoneMobile			= phoneMobile;
	        this.email      			= email;
	        this.password 			  	= password;
	        this.typeDocumentPersonal 	= typeDocumentPersonal;
	        this.numberDocumentPersonal = numberDocumentPersonal;
	        
	    }

	public static DriverResponse fromAggregate(Driver driver) {
		
		return new DriverResponse(driver.uid().value(), 
									driver.names().value(), 
									driver.lastName().value(), 
									driver.phoneMobile().value(), 
									driver.email().value(),
									driver.password().value(),
									driver.descriptionDocument(),
									driver.numberDocument());
	}

	public String uid() {
		return uid;
	}

	public String names() {
		return names;
	}

	public String lastName() {
		return lastName;
	}
	public String phoneMobile() {
		return phoneMobile;
	}
	public String email() {
		return email;
	}
	public String password() {
		return password;
	}
	public String typeDocumentPersonal() {
		return typeDocumentPersonal;
	}
	public String numberDocumentPersonal() {
		return numberDocumentPersonal;
	}
}
