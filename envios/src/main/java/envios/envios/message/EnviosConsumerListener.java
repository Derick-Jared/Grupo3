package envios.envios.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import envios.envios.dot.RequestEnvio;
import envios.envios.model.EnvioModel;
import envios.envios.service.IEnvioService;

@Component
public class EnviosConsumerListener {

    @Autowired
    private IEnvioService envioService;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receiveMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = consumerRecord.value();
        RequestEnvio data = objectMapper.readValue(message, RequestEnvio.class);

        EnvioModel newModel = new EnvioModel();
        newModel.setId(data.getIdEnvio());
        newModel.setEstado("RECI");
        envioService.updateEstado(newModel);
    }
}