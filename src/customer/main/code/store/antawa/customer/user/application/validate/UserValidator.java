package store.antawa.customer.user.application.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.antawa.customer.user.domain.InvalidUseremail;
import store.antawa.customer.user.domain.InvalidUserphonemobil;
import store.antawa.customer.user.domain.User;
import store.antawa.customer.user.domain.UserEmail;
import store.antawa.customer.user.domain.UserPhoneMobile;
import store.antawa.customer.user.domain.UserRepository;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.domain.criteria.Filter;
import store.antawa.shared.domain.criteria.Filters;
import store.antawa.shared.domain.criteria.Order;

@Service
public final class UserValidator {

	private final UserRepository repository;
	
	public UserValidator(UserRepository repository) {
		
		this.repository = repository;
	}
	
	public void validate(UserPhoneMobile phone, UserEmail email){
		
		ensurePhoneNotExist(phone);
		ensureEmailNotExist(email);
	}

	private void ensurePhoneNotExist(UserPhoneMobile phone) throws InvalidUserphonemobil{
		
		Optional<User> user = searchByPhone(phone);
		
		if (user.isPresent()) {
            throw new InvalidUserphonemobil(phone);
        }
		
	}
	
	private void ensureEmailNotExist(UserEmail email) throws InvalidUseremail{
		
		Optional<User> user = searchByEmail(email);
		
		if (user.isPresent()) {
            throw new InvalidUseremail(email);
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
    
    private Optional<User> searchByPhone(UserPhoneMobile phone) {
    	
    	Filter filter = Filter.create("phoneMobile", "=", phone.value());
		
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
