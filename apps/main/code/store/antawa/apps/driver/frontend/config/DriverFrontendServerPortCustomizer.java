package store.antawa.apps.driver.frontend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;

@Component
public final class DriverFrontendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

    private final Parameter param;
    
    public DriverFrontendServerPortCustomizer(Parameter param) {
        this.param = param;
    }
    
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(param.getInt("DRIVER_FRONTEND_SERVER_PORT"));
        } catch (ParameterNotExist parameterNotExist) {
            parameterNotExist.printStackTrace();
        }
    }
    
}
