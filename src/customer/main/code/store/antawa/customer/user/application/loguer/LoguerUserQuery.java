package store.antawa.customer.user.application.loguer;

import store.antawa.shared.domain.bus.query.Query;

public class LoguerUserQuery implements Query {

	private final String email;
	
	private final String password;
	 
    public LoguerUserQuery(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String email() {
        return email;
    }
    public String password() {
        return password;
    }
}
