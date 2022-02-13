package store.antawa.driver.driver.application.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.antawa.driver.driver.domain.Driver;
import store.antawa.driver.driver.domain.DriverEmail;
import store.antawa.driver.driver.domain.DriverImgAvatar;
import store.antawa.driver.driver.domain.DriverLastName;
import store.antawa.driver.driver.domain.DriverNames;
import store.antawa.driver.driver.domain.DriverPassword;
import store.antawa.driver.driver.domain.DriverPhoneMobile;
import store.antawa.driver.driver.domain.DriverRepository;
import store.antawa.driver.driver.domain.DriverUid;
import store.antawa.driver.driver.domain.InvalidDriverExistsEmail;
import store.antawa.driver.driver.domain.InvalidDriverExistsUID;
import store.antawa.driver.personal_document.application.PersonalDocumentResponse;
import store.antawa.driver.personal_document.application.find.FindPersonalDocumentQuery;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.event.EventBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.domain.criteria.Filter;
import store.antawa.shared.domain.criteria.Filters;
import store.antawa.shared.domain.criteria.Order;

@Service
public final class DriverCreator {

    private final DriverRepository repository;
    private final EventBus         eventBus;
    private final QueryBus         queryBus;
    
    private final static String IMAGE_NAME_EMPTY = "";
    
    public DriverCreator(DriverRepository repository, EventBus eventBus, QueryBus queryBus) {
    	
    	this.repository = repository;
    	this.eventBus   = eventBus;
    	this.queryBus   = queryBus;
    }
    
    public void create(DriverUid uid, 
    		DriverEmail email, 
    		DriverLastName lastName, 
    		DriverNames names, 
    		DriverPassword password, 
    		DriverPhoneMobile phone,
    		String personalDocumentUid,
    		String numberDocument) {

    	Optional<Driver> driverBD = repository.search(uid);
    	Optional<Driver> driverEmailBD = searchByEmail(email);
    	
    	if( driverBD.isPresent() ) {
    		 throw new InvalidDriverExistsUID(uid); 
    	}
    	
    	if(driverEmailBD.isPresent()) {
    		throw new InvalidDriverExistsEmail(email);
    	}
    	
    	PersonalDocumentResponse personalDocument = searchPersonalDocument(personalDocumentUid);
    	
    	Driver driver = Driver.create(uid, 
    			names, 
    			lastName, 
    			phone, 
    			email, 
    			password, 
    			new DriverImgAvatar(IMAGE_NAME_EMPTY), 
    			personalDocument.uid(), 
    			numberDocument, 
    			personalDocument.name());
    	
    	repository.save(driver);
    	
    	eventBus.publish(driver.pullDomainEvents());
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
    
    private PersonalDocumentResponse searchPersonalDocument(String uid) {
    
    	PersonalDocumentResponse personalDocument = queryBus.ask(new FindPersonalDocumentQuery(uid));

    	return personalDocument; 
    }
}
