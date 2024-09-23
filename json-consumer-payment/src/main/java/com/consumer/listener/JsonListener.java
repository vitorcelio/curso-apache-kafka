package com.consumer.listener;

import com.consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antifraude(@Payload Payment payment) {
        log.info("Recebi o pagemento ::: {}", payment.toString());
        sleep(2000);

        log.info("ANTIFRAUDE ::: validando informações do pagemento");
        sleep(2000);

        log.info("COMPRA APROVADA...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGerador(@Payload Payment payment) {
        sleep(3000);
        log.info("GERANDO PDF DO PRODUTO DE ID {}...", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) {
        sleep(3000);
        log.info("ENVIANDO EMAIL PARA O USUARIO DE ID {}...", payment.getUserId());
    }
}
