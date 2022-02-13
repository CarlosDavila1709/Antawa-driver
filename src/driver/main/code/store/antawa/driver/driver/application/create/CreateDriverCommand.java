package store.antawa.driver.driver.application.create;

import store.antawa.shared.domain.bus.command.Command;

public class CreateDriverCommand implements Command{
	
	private final String uid;
    private final String names;
    private final String lastName;
    private final String phoneMobile;
    private final String email;
    private final String password;
    private final String personalDocumentUid;
    private final String numberDocument;
    
    public CreateDriverCommand(String uid, String names, String lastName, String phoneMobile, String email, String password, String personalDocumentUid, String numberDocument) {
    	this.uid 		 		 = uid;
    	this.email		 		 = email;
    	this.password 	 		 = password;
    	this.names		 		 = names;
    	this.lastName    		 = lastName;
    	this.phoneMobile 		 = phoneMobile;
    	this.personalDocumentUid = personalDocumentUid;
    	this.numberDocument		 = numberDocument;
    	
    }    
    public String uid() {
    	return uid;
    }
    public String email() {
        return email;
    }
    public String password() {
        return password;
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
    public String personalDocumentUid() {
    	return personalDocumentUid;
    }
    public String numberDocument() {
    	return numberDocument;
    }
}
