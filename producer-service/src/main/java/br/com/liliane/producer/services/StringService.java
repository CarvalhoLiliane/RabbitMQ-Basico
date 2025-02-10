package br.com.liliane.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.liliane.producer.config.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.com.liliane.producer.config.RabbitMQConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
//Essa anotação do Lombok gera um construtor que aceita como parâmetros todos os campos declarados como final ou @NonNull
// da classe. Isso permite injeção de dependências por construtor, que é a prática recomendada no Spring.
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Mensagem recebida " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }
}
