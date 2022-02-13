package store.antawa.backoffice.user.application.loguer;

import store.antawa.shared.domain.bus.query.Query;

public class LoguerUserBackofficeQuery implements Query {

	private final String email;
	
	private final String password;
	
    public LoguerUserBackofficeQuery(String email, String password) {
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
