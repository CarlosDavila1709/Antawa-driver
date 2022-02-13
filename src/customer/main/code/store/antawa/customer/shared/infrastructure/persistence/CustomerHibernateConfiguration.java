package store.antawa.customer.shared.infrastructure.persistence;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;
import store.antawa.shared.infrastructure.hibernate.HibernateConfigurationFactory;

@Configuration
@EnableTransactionManagement
public class CustomerHibernateConfiguration {


    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "customer";
 
    public CustomerHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
    	
        this.factory = factory;
        this.config  = config;
    }
    
    @Bean("customer-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }
    
    @Bean("customer-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("customer-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("CUSTOMER_DATABASE_HOST"),
            config.getInt("CUSTOMER_DATABASE_PORT"),
            config.get("CUSTOMER_DATABASE_NAME"),
            config.get("CUSTOMER_DATABASE_USER"),
            config.get("CUSTOMER_DATABASE_PASSWORD")
        );
    }
}
