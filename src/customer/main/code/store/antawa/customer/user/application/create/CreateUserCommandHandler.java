package store.antawa.customer.user.application.create;

import store.antawa.customer.user.domain.UserEmail;
import store.antawa.customer.user.domain.UserLastName;
import store.antawa.customer.user.domain.UserName;
import store.antawa.customer.user.domain.UserPassword;
import store.antawa.customer.user.domain.UserPhoneMobile;
import store.antawa.customer.user.domain.UserUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUserCommand>{

	private final UserCreator creator;
	
	public CreateUserCommandHandler(UserCreator creator) {
		
		this.creator = creator;
	}
	
	@Override
	public void handle(CreateUserCommand command) {
		
		UserUid uid = new UserUid(command.uid());
		UserName name = new UserName(command.names());
		UserLastName lastName = new UserLastName(command.lastName());
		UserEmail email = new UserEmail(command.email());
		UserPhoneMobile phoneMobile = new UserPhoneMobile(command.phoneMobile());
		UserPassword password = new UserPassword(command.password());
		String personalDocumentUid = command.personalDocumentUid();
		String numberDocument = command.numberDocument();
		
		this.creator.create(uid, name, lastName, email, phoneMobile, password, personalDocumentUid, numberDocument);
		
	}
}
