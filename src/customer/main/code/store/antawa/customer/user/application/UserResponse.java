package store.antawa.customer.user.application;

import store.antawa.customer.user.domain.User;
import store.antawa.shared.domain.bus.query.Response;

public final class UserResponse implements Response{

	private final String uid;
	private final String names;
	private final String lastName;
	private final String phoneMobile;
	private final String email;
	private final String password;
	private final String personalDocumentUid;
	private final String numberDocumentPersonal;
	
	public UserResponse(
			String uid, 
			String names, 
			String lastName,
			String phoneMobile, 
			String email, 
			String password, 
			String personalDocumentUid, 
			String numberDocumentPersonal) {
		
        this.uid        			= uid;
        this.names      			= names;
        this.lastName 				= lastName;
        this.phoneMobile			= phoneMobile;
        this.email      			= email;
        this.password 			  	= password;
        this.personalDocumentUid 	= personalDocumentUid;
        this.numberDocumentPersonal = numberDocumentPersonal;
	}
	
	public static UserResponse fromAggregate(User user) {
		
		return new UserResponse(
								user.uid().value(),
								user.names().value(),
								user.lastName().value(),
								user.phoneMobile().value(),
								user.email().value(),
								user.password().value(),
								user.personalDocumentUid(),
								user.numberDocument()
								);
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
	public String personalDocumentUid() {
		return personalDocumentUid;
	}
	public String numberDocumentPersonal() {
		return numberDocumentPersonal;
	}
}
