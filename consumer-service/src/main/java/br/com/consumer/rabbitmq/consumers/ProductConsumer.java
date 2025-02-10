package br.com.consumer.rabbitmq.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static constants.RabbitMQConstans.QUEUE_PRODUCT_LOG;
import static constants.RabbitMQConstans.RK_PRODUCT_LOG;

@Component
@Log4j2
public class ProductConsumer {

    @RabbitListener(queues = {RK_PRODUCT_LOG})
    public void consumer(ProductDTO message) {
        try {
            log.info("Mensagem recebida pelo consumidor: " + message.toString());
        } catch (Exception e) {
            log.error("Erro ao processar a mensagem: ", e);
        }
    }

}
