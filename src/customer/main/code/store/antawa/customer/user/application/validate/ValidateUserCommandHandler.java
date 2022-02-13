package store.antawa.customer.user.application.validate;

import store.antawa.customer.user.domain.UserEmail;
import store.antawa.customer.user.domain.UserPhoneMobile;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public class ValidateUserCommandHandler implements CommandHandler<ValidateUserCommand> {

	private final UserValidator validator;
	
	public ValidateUserCommandHandler(UserValidator validator) {
	
		this.validator = validator;
	}
	
	@Override
	public void handle(ValidateUserCommand command) {
		
		UserPhoneMobile phone = new UserPhoneMobile(command.phoneMobil());
		UserEmail email = new UserEmail(command.email());
		
		this.validator.validate(phone, email);
	}
}
