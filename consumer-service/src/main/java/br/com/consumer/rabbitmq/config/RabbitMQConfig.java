package br.com.consumer.rabbitmq.config;

import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //para lidar com mensagens serializadas em java
    @Bean
    public SimpleMessageConverter messageConverter() {
        return new SimpleMessageConverter();
    }

}
