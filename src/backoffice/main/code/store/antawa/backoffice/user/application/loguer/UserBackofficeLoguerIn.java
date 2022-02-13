package store.antawa.backoffice.user.application.loguer;

import store.antawa.backoffice.user.domain.UserRepository;
import store.antawa.backoffice.user.domain.InvalidUserCredentials;
import store.antawa.backoffice.user.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.antawa.backoffice.user.UserResponse;
import store.antawa.backoffice.user.domain.UserEmail;
import store.antawa.backoffice.user.domain.UserNotExist;
import store.antawa.backoffice.user.domain.UserPassword;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.domain.criteria.Filter;
import store.antawa.shared.domain.criteria.Filters;
import store.antawa.shared.domain.criteria.Order;

@Service
public final class UserBackofficeLoguerIn {

	private final UserRepository repository;
	
	public UserBackofficeLoguerIn(UserRepository repository) {
		this.repository = repository;
	}
	
	public UserResponse search(UserEmail email,UserPassword password) throws UserNotExist
	{
		Optional<User> auth = searchByEmail(email);
		
		
        ensureUserExist(auth, email);
        ensureCredentialsAreValid(auth.get(), password);
        
		return auth
                .map(UserResponse::fromAggregate)
                .orElseThrow(() -> new UserNotExist(email));
	}
	
    private void ensureUserExist(Optional<User> auth, UserEmail email) {
        if (!auth.isPresent()) {
            throw new InvalidUserCredentials(email);
        }
    }

    private void ensureCredentialsAreValid(User auth, UserPassword password) {
        if (!auth.passwordMatches(password)) {
            throw new InvalidUserCredentials(auth.email());
        }
    }
    private Optional<User> searchByEmail(UserEmail email) {
    	
    	Filter filter = Filter.create("email", "=", email.value());
		
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(filter);

    	Criteria criteria = new Criteria(new Filters(filters),
						                Order.none(),
						                Optional.empty(),
						                Optional.empty());
    	
    	List<User> list = repository.matching(criteria);
    	
    	if(list==null || list.size()<=0) {
    		return Optional.empty();
    	}
    	
    	return Optional.of(list.get(0));

    }
}
