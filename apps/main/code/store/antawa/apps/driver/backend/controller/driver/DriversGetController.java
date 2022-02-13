package store.antawa.apps.driver.backend.controller.driver;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import store.antawa.driver.driver.application.DriversResponse;
import store.antawa.driver.driver.application.search_all.SearchAllDriversQuery;
import store.antawa.shared.domain.DomainError;
import store.antawa.shared.domain.bus.command.CommandBus;
import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;
import store.antawa.shared.infrastructure.spring.ApiController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class DriversGetController extends ApiController {

    public DriversGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    
    @GetMapping("/drivers") 
    public HashMap<String, List<HashMap<String, String>>> index() throws QueryHandlerExecutionError {
        
    	DriversResponse drivers = ask(
            new SearchAllDriversQuery()
        );

    	HashMap<String, List<HashMap<String, String>>> _res = new  HashMap<String, List<HashMap<String, String>>>();
    	
    	List<HashMap<String, String>> conductores = drivers.drivers().stream().map(response -> new HashMap<String, String>() {{
            
    		put("id", response.uid());
            put("email", response.email());
            put("nombre", response.names());
            put("apellidos", response.lastName());
            put("telefono", response.phoneMobile());
            put("documento", response.typeDocumentPersonal());
            put("numeroDocumento", response.numberDocumentPersonal());
            
        }}).collect(Collectors.toList());
        
    	_res.put("conductores", conductores);
    	Response response = new Response();
    	response.setConductores(conductores);
    	
    	return _res;
       // return  ResponseEntity.ok().body(response);
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

 class Response {
	
	private List<HashMap<String, String>> conductores;
	
	public void setConductores(List<HashMap<String, String>> conductores) {
		
		this.conductores = conductores;
		
	}
	
	public List<HashMap<String, String>> conductores(){
		
		return conductores;
	
	}

}
