package store.antawa.driver.driver.domain;

import java.util.Objects;
import store.antawa.shared.domain.AggregateRoot;
import store.antawa.shared.domain.DriverCreatedDomainEvent;

public final class Driver extends AggregateRoot{

	private final DriverUid uid;
    private final DriverNames names;
    private final DriverLastName lastName;
    private final DriverPhoneMobile phoneMobile;
    private final DriverEmail email;
    private final DriverPassword password;
    private final DriverImgAvatar imgAvatar;
    private final String personalDocumentUid;
    private final String numberDocument;
    private final String descriptionDocument;
    
    public Driver(DriverUid uid,
    		DriverNames names,
    		DriverLastName lastName,
    		DriverPhoneMobile phoneMobile,
    		DriverEmail email,
    		DriverPassword password,
    		DriverImgAvatar imgAvatar,
    		String personalDocumentUid,
    		String numberDocument,
    		String descriptionDocument) {
    	
    	this.uid 				 = uid;
    	this.names 				 = names;
    	this.lastName 			 = lastName;
    	this.phoneMobile 		 = phoneMobile;
    	this.email 				 = email;
    	this.password 			 = password;
    	this.imgAvatar 			 = imgAvatar;
    	this.personalDocumentUid = personalDocumentUid;
    	this.numberDocument 	 = numberDocument;
    	this.descriptionDocument = descriptionDocument;
    }
    
    public Driver() {
    	this.uid = null;
    	this.names = null;
    	this.lastName = null;
    	this.phoneMobile = null;
    	this.email = null;
    	this.password = null;
    	this.imgAvatar = null;
    	this.personalDocumentUid = null;
    	this.numberDocument = null;
    	this.descriptionDocument = null;
    }
    
    public static Driver create(DriverUid uid,
    		DriverNames names,
    		DriverLastName lastName,
    		DriverPhoneMobile phoneMobile,
    		DriverEmail email,
    		DriverPassword password,
    		DriverImgAvatar imgAvatar,
    		String personalDocumentUid,
    		String numberDocument,
    		String descriptionDocument) {
    	
    	Driver driver = new Driver(uid, names, lastName, phoneMobile, email, password, imgAvatar, personalDocumentUid,numberDocument, descriptionDocument);
    	
    	driver.record(new DriverCreatedDomainEvent(uid.value(), email.value()));
    	
    	return driver;
    }
    
    public DriverUid uid() {
    	return uid;
    }
    public DriverNames names() {
    	return names;
    }
    public DriverLastName lastName() {
    	return lastName;
    }
    public DriverPhoneMobile phoneMobile() {
    	return phoneMobile;
    }
    public DriverEmail email() {
    	return email;
    }
    public DriverPassword password() {
    	return password;
    }
    public boolean passwordMatches(DriverPassword password) {
        return this.password.equals(password);
    }
    public boolean uidMatches(DriverUid uid) {
        return this.uid.equals(uid);
    }
    public boolean emailMatches(DriverEmail email) {
    	return this.email.equals(email);
    }
    public DriverImgAvatar imgAvatar() {
    	return imgAvatar;
    }
    public String numberDocument() {
    	return numberDocument;
    }
    public String descriptionDocument() {
    	return descriptionDocument;
    }
    public String personalDocumentUid() {
    	return personalDocumentUid;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Driver driver = (Driver) o;
        return uid.equals(driver.uid) &&
               email.equals(driver.email) &&
               numberDocument.equals(driver.numberDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash( uid,
        		 names,
        		 lastName,
        		 phoneMobile,
        		 email,
        		 password,
        		 numberDocument,
        		 descriptionDocument);
    }
}
