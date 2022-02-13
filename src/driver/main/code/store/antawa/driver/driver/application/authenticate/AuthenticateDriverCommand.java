package store.antawa.driver.driver.application.authenticate;

import store.antawa.shared.domain.bus.command.Command;

public final class AuthenticateDriverCommand implements Command {
	
	private final String email;
    private final String password;

    public AuthenticateDriverCommand(String email, String password) {
        this.email 		= email;
        this.password 	= password;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }
}
