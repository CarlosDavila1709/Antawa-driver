package store.antawa.driver.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import store.antawa.shared.infrastructure.bus.event.DomainEventsInformation;
import store.antawa.shared.infrastructure.bus.event.postgres.MySqlDomainEventsConsumer;
import store.antawa.shared.infrastructure.bus.event.postgres.MySqlEventBus;
import store.antawa.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class DriverMySqlEventBusConfiguration {

	private final SessionFactory sessionFactory;
	private final DomainEventsInformation domainEventsInformation;
	private final SpringApplicationEventBus bus;

	public DriverMySqlEventBusConfiguration(
			@Qualifier("driver-session_factory") SessionFactory sessionFactory,
			DomainEventsInformation domainEventsInformation, SpringApplicationEventBus bus) {
		this.sessionFactory = sessionFactory;
		this.domainEventsInformation = domainEventsInformation;
		this.bus = bus;
	}

	@Bean
	public MySqlEventBus DriverMysqlEventBus() {
		return new MySqlEventBus(sessionFactory);
	}

	@Bean
	public MySqlDomainEventsConsumer DriverMySqlDomainEventsConsumer() {
		return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
	}
}
