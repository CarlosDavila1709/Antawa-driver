package store.antawa.backoffice.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import store.antawa.shared.infrastructure.bus.event.DomainEventsInformation;
import store.antawa.shared.infrastructure.bus.event.postgres.MySqlDomainEventsConsumer;
import store.antawa.shared.infrastructure.bus.event.postgres.MySqlEventBus;
import store.antawa.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class BackofficeMySqlEventBusConfiguration {

	private final SessionFactory sessionFactory;
	private final DomainEventsInformation domainEventsInformation;
	private final SpringApplicationEventBus bus;

	public BackofficeMySqlEventBusConfiguration(
			@Qualifier("backoffice-session_factory") SessionFactory sessionFactory,
			DomainEventsInformation domainEventsInformation, SpringApplicationEventBus bus) {
		this.sessionFactory = sessionFactory;
		this.domainEventsInformation = domainEventsInformation;
		this.bus = bus;
	}

	@Bean
	public MySqlEventBus BackofficeMysqlEventBus() {
		return new MySqlEventBus(sessionFactory);
	}

	@Bean
	public MySqlDomainEventsConsumer BackofficeMySqlDomainEventsConsumer() {
		return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
	}
}
