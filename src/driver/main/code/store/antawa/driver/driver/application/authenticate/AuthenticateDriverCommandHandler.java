package store.antawa.driver.driver.application.authenticate;

import store.antawa.driver.driver.domain.DriverEmail;
import store.antawa.driver.driver.domain.DriverPassword;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateDriverCommandHandler implements CommandHandler<AuthenticateDriverCommand> {

	private final DriverAuthenticator authenticator;
	
	public AuthenticateDriverCommandHandler(DriverAuthenticator authenticator) {
		
		this.authenticator = authenticator;
	}
	
	@Override
	public void handle(AuthenticateDriverCommand command) {
		
        DriverEmail email = new DriverEmail(command.email());
        DriverPassword password = new DriverPassword(command.password());

        authenticator.authenticate(email, password);
		
	}

}
