package store.antawa.customer.user.domain;

import java.util.Objects;
import store.antawa.shared.domain.AggregateRoot;

public final class User extends AggregateRoot{

	private final UserUid uid;
	private final UserName names;
	private final UserLastName lastName;
	private final UserEmail email;
	private final UserPhoneMobile phoneMobile;
	private final UserPassword password;
    private final String personalDocumentUid;
    private final String numberDocument;
    
	public User(
			UserUid uid,
			UserName names,
			UserLastName lastName,
			UserEmail email,
			UserPhoneMobile phoneMobile,
			UserPassword password,
			String personalDocumentUid,
			String numberDocument) {
		
    	this.uid 				 = uid;
    	this.names 				 = names;
    	this.lastName 			 = lastName;
    	this.phoneMobile 		 = phoneMobile;
    	this.email 				 = email;
    	this.password 			 = password;
    	this.personalDocumentUid = personalDocumentUid;
    	this.numberDocument 	 = numberDocument;

	}
	
	public User() {
    	this.uid 				 = null;
    	this.names 				 = null;
    	this.lastName 			 = null;
    	this.phoneMobile 		 = null;
    	this.email 				 = null;
    	this.password 			 = null;
    	this.personalDocumentUid = null;
    	this.numberDocument 	 = null;
	}
	
	public static User create(
			UserUid uid,
			UserName names,
			UserLastName lastName,
			UserEmail email,
			UserPhoneMobile phoneMobile,
			UserPassword password,
			String personalDocumentUid,
			String numberDocument) {
		
		User user = new User(uid, names, lastName, email, phoneMobile, password, personalDocumentUid, numberDocument);
		
		return user;
	}
	
	public UserUid uid() {
		return uid;
	}
	public UserName names() {
		return names;
	}
	public UserLastName lastName() {
		return lastName;
	}
	public UserEmail email() {
		return email;
	}
	public UserPhoneMobile phoneMobile() {
		return phoneMobile;
	}
	public UserPassword password() {
		return password;
	}
	public String personalDocumentUid() {
		return personalDocumentUid;
	}
	public String numberDocument() {
		return numberDocument;
	}
    public boolean passwordMatches(UserPassword password) {
        return this.password.equals(password);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User driver = (User) o;
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
        		 numberDocument);
    }
}
