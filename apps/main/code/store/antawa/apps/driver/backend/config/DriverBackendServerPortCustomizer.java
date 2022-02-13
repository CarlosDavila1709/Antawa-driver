package store.antawa.apps.driver.backend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;

@Component
public class DriverBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

	
	private final Parameter param;

	public DriverBackendServerPortCustomizer(Parameter param) {

		this.param = param;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("DRIVER_BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}
