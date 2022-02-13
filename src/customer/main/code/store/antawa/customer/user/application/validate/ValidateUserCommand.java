package store.antawa.customer.user.application.validate;

import store.antawa.shared.domain.bus.command.Command;

public final class ValidateUserCommand implements Command {

    private final String phoneMobil;
    private final String email;
    
    public ValidateUserCommand(String phoneMobil, String email) {
    	
    	this.phoneMobil = phoneMobil;
    	this.email      = email;
    }
    
    public String phoneMobil() {
        return phoneMobil;
    }
    public String email() {
        return email;
    }
}
