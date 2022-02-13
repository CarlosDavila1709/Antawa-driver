package store.antawa.driver.driver.application.loguer;

import store.antawa.shared.domain.bus.query.Query;

public class LoguerDriverQuery implements Query{

	private final String email;
	
	private final String password;
	
	 
    public LoguerDriverQuery(String email, String password) {
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
