package store.antawa.backoffice.user.application.validate;

import store.antawa.backoffice.user.domain.UserRepository;
import store.antawa.shared.domain.Service;

@Service
public final class UserBackofficeValidator {

	private final UserRepository repository;
	
	
	public UserBackofficeValidator(UserRepository repository) {
		
		this.repository = repository;
	}
	
}
