package nl.bep3_teamtwee.inventory_service.infrastructure.config;

import nl.bep3_teamtwee.inventory_service.infrastructure.driven.messaging.RabbitMqEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public RabbitMqEventPublisher EventPublisher(RabbitTemplate template) {
        return new RabbitMqEventPublisher(template);
    }

}
