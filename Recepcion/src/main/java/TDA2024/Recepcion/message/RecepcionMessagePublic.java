package TDA2024.Recepcion.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA2024.Recepcion.models.RecepcionModel;

@Component
public class RecepcionMessagePublic {
    @Value("${spring.kafka.template.default-topic}")
    String topico;

    private static final Logger logger = LoggerFactory.getLogger(RecepcionMessagePublic.class);

    @Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void EnviarEnvioEvento(RecepcionModel recepcion) throws JsonProcessingException{
        String value = objectMapper.writeValueAsString(recepcion);
        kafkaTemplate.send(topico, value);
    }
}
