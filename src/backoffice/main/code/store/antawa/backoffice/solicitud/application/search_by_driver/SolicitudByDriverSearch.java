package store.antawa.backoffice.solicitud.application.search_by_driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import store.antawa.backoffice.solicitud.application.SolicitudResponse;
import store.antawa.backoffice.solicitud.domain.Solicitud;
import store.antawa.backoffice.solicitud.domain.SolicitudDriverNotExist;
import store.antawa.backoffice.solicitud.domain.SolicitudRepository;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.criteria.Criteria;
import store.antawa.shared.domain.criteria.Filter;
import store.antawa.shared.domain.criteria.Filters;
import store.antawa.shared.domain.criteria.Order;

@Service
public final class SolicitudByDriverSearch {

	private final SolicitudRepository repository;
	
	public SolicitudByDriverSearch(SolicitudRepository repository) {
		
		this.repository = repository;
	}
	
	public SolicitudResponse search(String uidDriver) {
		
		Optional<Solicitud> solicitudBD = searchByDriverUid(uidDriver);
		
		if(!solicitudBD.isPresent()) {
			throw new SolicitudDriverNotExist(uidDriver);
		}

		return SolicitudResponse.fromAggregate(solicitudBD.get());
	}
	
	public Optional<Solicitud> searchByDriverUid(String uidDriver){
	 	
		Filter filter = Filter.create("driverUid", "=", uidDriver);
		
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(filter);
		
    	Criteria criteria = new Criteria(new Filters(filters),
                Order.none(),
                Optional.empty(),
                Optional.empty());
    	
    	List<Solicitud> lst = repository.matching(criteria);
    	
    	if(lst==null || lst.size()<=0) {
    		return Optional.empty();
    	}
    	
    	return Optional.of(lst.get(0));
		
	}
}
