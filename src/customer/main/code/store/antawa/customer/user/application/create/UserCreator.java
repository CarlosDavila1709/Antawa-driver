package store.antawa.customer.user.application.create;


import store.antawa.customer.user.application.validate.ValidateUserCommand;

import store.antawa.customer.user.domain.User;
import store.antawa.customer.user.domain.UserEmail;
import store.antawa.customer.user.domain.UserLastName;
import store.antawa.customer.user.domain.UserName;
import store.antawa.customer.user.domain.UserPassword;
import store.antawa.customer.user.domain.UserPhoneMobile;
import store.antawa.customer.user.domain.UserRepository;
import store.antawa.customer.user.domain.UserUid;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.command.CommandBus;

@Service
public final class UserCreator {

	private final UserRepository repository;
    private final CommandBus	   commandBus;	
	
    public UserCreator( UserRepository repository, CommandBus commandBus) {
    	
    	this.repository = repository;
    	this.commandBus = commandBus;
    }
    
    public void create(
    		UserUid uid,
    		UserName name,
    		UserLastName lastName,
    		UserEmail email,
    		UserPhoneMobile phoneMobile,
    		UserPassword password,
    		String personalDocumentUid,
    		String numberDocument){

    	
    	commandBus.dispatch(new ValidateUserCommand(phoneMobile.value(), email.value()));
    	
    	User user = User.create(uid, name, lastName, email, phoneMobile, password, personalDocumentUid, numberDocument);
    	
    	repository.save(user);
    }

}
