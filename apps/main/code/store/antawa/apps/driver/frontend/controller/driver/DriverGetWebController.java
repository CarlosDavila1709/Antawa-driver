package store.antawa.apps.driver.frontend.controller.driver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import store.antawa.shared.domain.bus.query.QueryBus;
import store.antawa.shared.domain.bus.query.QueryHandlerExecutionError;

@Controller
public final class DriverGetWebController {

    private final QueryBus bus;
    
    public DriverGetWebController(QueryBus bus)
    {
    	this.bus = bus;
    }
    
    @GetMapping("/grocerys")
    public ModelAndView index(
        @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
        @ModelAttribute("errors") HashMap<String, List<String>> errors
    ) throws QueryHandlerExecutionError {
       
        return new ModelAndView("pages/driver/driver", new HashMap<String, Serializable>() {{
            put("title", "Tiendas");
            put("description", "Courses CodelyTV - Backoffice");
            put("courses_counter", 10);
            put("inputs", inputs);
            put("errors", errors);
            put("generated_uuid", UUID.randomUUID().toString());
        }});
    }
}
