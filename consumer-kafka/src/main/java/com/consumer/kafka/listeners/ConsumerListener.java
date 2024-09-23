package com.consumer.kafka.listeners;

import com.consumer.kafka.custom.ConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ConsumerListener {

    @SneakyThrows
    @ConsumerCustomListener(groupId = "grupo-1")
    public void create(String message) {
        log.info("CREATE ::: Mensagem recebida: {}", message);
        throw new IllegalArgumentException("EXCEPTION ...");
    }

    @ConsumerCustomListener(groupId = "grupo-1")
    public void log(String message) {
        log.info("LOG ::: Mensagem recebida: {}", message);
    }

    @KafkaListener(groupId = "grupo-2", topics = "topic-kafka", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Mensagem recebida: {}", message);
    }

}
