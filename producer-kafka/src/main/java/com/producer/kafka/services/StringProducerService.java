package com.producer.kafka.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final View error;

    public void sendMessage(String message) {
        kafkaTemplate.send("topic-kafka", message).whenComplete(
          (success, throwable) -> {
              if(throwable != null) {
                log.error("Erro: ", throwable);
              }

              if(success != null) {
                  log.info("Mensagem sucesso {}", success.getProducerRecord().value());
                  log.info("Partição {}, offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
              }
          }
        );
    }

}
