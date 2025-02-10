package br.com.liliane.producer.services;


import constants.RabbitMQConstans;
import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor// gera por debaixo dos panos o construtor com parametros
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto){
        log.info("Enviando uma mensagem para a exchange " + dto.toString());
        rabbitTemplate.convertAndSend(RabbitMQConstans.EXG_NAME_MARKETPLACE, RabbitMQConstans.RK_PRODUCT_LOG, dto);
    }
}
