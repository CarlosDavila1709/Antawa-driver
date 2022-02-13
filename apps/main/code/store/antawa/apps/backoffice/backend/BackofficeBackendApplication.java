package store.antawa.apps.backoffice.backend;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import store.antawa.shared.domain.Service;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"store.antawa.shared", "store.antawa.backoffice", "store.antawa.apps.backoffice.backend"}
)
public class BackofficeBackendApplication {

	public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
        }};
    }
}
