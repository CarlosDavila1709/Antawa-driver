package store.antawa.driver.driver.application.create;

import store.antawa.driver.driver.domain.DriverEmail;
import store.antawa.driver.driver.domain.DriverLastName;
import store.antawa.driver.driver.domain.DriverNames;
import store.antawa.driver.driver.domain.DriverPassword;
import store.antawa.driver.driver.domain.DriverPhoneMobile;
import store.antawa.driver.driver.domain.DriverUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateDriverCommandHandler implements CommandHandler<CreateDriverCommand>{

	private final DriverCreator creator;
	
	public CreateDriverCommandHandler(DriverCreator creator) {
		
		this.creator = creator;
	}
	
	@Override
	public void handle(CreateDriverCommand command) {
		
		DriverUid 			uid 				= new DriverUid(command.uid());
		DriverEmail 		email 				= new DriverEmail(command.email());
		DriverLastName 		lastName 			= new DriverLastName(command.lastName());
		DriverNames 		names 				= new DriverNames(command.names());
		DriverPassword 		password 			= new DriverPassword(command.password());
		DriverPhoneMobile 	phone 				= new DriverPhoneMobile(command.phoneMobile());
		String 				personaldocumentUid = command.personalDocumentUid();
		String 				numberDocument		= command.numberDocument();
		
		creator.create(uid, email, lastName, names, password, phone, personaldocumentUid, numberDocument);
		
	}

}
