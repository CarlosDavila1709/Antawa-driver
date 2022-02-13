package store.antawa.apps.customer.backend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;

@Component
public class CustomerBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

	private final Parameter param;

	public CustomerBackendServerPortCustomizer(Parameter param) {

		this.param = param;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("CUSTOMER_BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}
