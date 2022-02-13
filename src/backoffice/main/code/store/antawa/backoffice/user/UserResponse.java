package store.antawa.backoffice.user;

import store.antawa.backoffice.user.domain.User;
import store.antawa.shared.domain.bus.query.Response;

public final class UserResponse implements Response {

	private final String uid;
	private final String names;
	private final String lastName;
	private final String email;
	private final String password;

	public UserResponse(
			String uid, 
			String names, 
			String lastName,
			String email, 
			String password) {
		
        this.uid        			= uid;
        this.names      			= names;
        this.lastName 				= lastName;
        this.email      			= email;
        this.password 			  	= password;
	}
	
	public static UserResponse fromAggregate(User user) {
		
		return new UserResponse(
								user.uid().value(),
								user.names().value(),
								user.lastName().value(),
								user.email().value(),
								user.password().value()
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
	public String email() {
		return email;
	}
	public String password() {
		return password;
	}
}
