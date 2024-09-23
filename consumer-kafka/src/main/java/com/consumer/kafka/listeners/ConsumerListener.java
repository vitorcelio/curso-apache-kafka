package com.consumer.kafka.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class ConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "topic-kafka", containerFactory = "concurrentContainerFactory")
    public void listener(String message) {
       log.info("Mensagem recebida: {}", message);
    }

}
