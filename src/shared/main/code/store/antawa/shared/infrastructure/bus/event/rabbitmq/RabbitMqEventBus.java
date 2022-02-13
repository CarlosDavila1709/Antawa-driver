package store.antawa.shared.infrastructure.bus.event.rabbitmq;

import org.springframework.amqp.AmqpException;
import store.antawa.shared.domain.bus.event.DomainEvent;
import store.antawa.shared.domain.bus.event.EventBus;
import store.antawa.shared.infrastructure.bus.event.postgres.MySqlEventBus;

import java.util.Collections;
import java.util.List;

public class RabbitMqEventBus implements EventBus {
    private final store.antawa.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;
    private final String            exchangeName;

    public RabbitMqEventBus(store.antawa.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher publisher, MySqlEventBus failoverPublisher) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
