package store.antawa.driver.shared.infrastructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;
import store.antawa.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class DriverHibernateConfiguration {

    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "driver";
    
    public DriverHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
    	
        this.factory = factory;
        this.config  = config;
    }
    
    @Bean("driver-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }
    
    @Bean("driver-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("driver-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("DRIVER_DATABASE_HOST"),
            config.getInt("DRIVER_DATABASE_PORT"),
            config.get("DRIVER_DATABASE_NAME"),
            config.get("DRIVER_DATABASE_USER"),
            config.get("DRIVER_DATABASE_PASSWORD")
        );
    }
}
