package store.antawa.driver.driver.application.loguer;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.domain.Driver;
import store.antawa.driver.driver.domain.DriverEmail;
import store.antawa.driver.driver.domain.DriverPassword;
import store.antawa.driver.driver.domain.DriverRepository;
import store.antawa.driver.driver.domain.EmailNotExist;
import store.antawa.driver.driver.domain.InvalidDriverCredentials;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.domain.criteria.Filter;
import store.antawa.shared.domain.criteria.Filters;
import store.antawa.shared.domain.criteria.Order;

@Service
public class DriverLoguerIn {

	private final DriverRepository repository;
	
	public DriverLoguerIn(DriverRepository repository) {
		this.repository = repository;
	}
	
	public DriverResponse search(DriverEmail email,DriverPassword password) throws EmailNotExist
	{
    	
		Optional<Driver> auth = searchByEmail(email);
		
		
        ensureUserExist(auth, email);
        ensureCredentialsAreValid(auth.get(), password);
        
		return auth
                .map(DriverResponse::fromAggregate)
                .orElseThrow(() -> new EmailNotExist(email));
	}
	
    private void ensureUserExist(Optional<Driver> auth, DriverEmail email) {
        if (!auth.isPresent()) {
            throw new InvalidDriverCredentials(email);
        }
    }

    private void ensureCredentialsAreValid(Driver auth, DriverPassword password) {
        if (!auth.passwordMatches(password)) {
            throw new InvalidDriverCredentials(auth.email());
        }
    }
    private Optional<Driver> searchByEmail(DriverEmail email) {
    	
    	Filter filter = Filter.create("email", "=", email.value());
		
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(filter);

    	Criteria criteria = new Criteria(new Filters(filters),
						                Order.none(),
						                Optional.empty(),
						                Optional.empty());
    	
    	List<Driver> list = repository.matching(criteria);
    	
    	if(list==null || list.size()<=0) {
    		return Optional.empty();
    	}
    	
    	return Optional.of(list.get(0));

    }
}
