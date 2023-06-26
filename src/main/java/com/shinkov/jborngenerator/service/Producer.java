package com.shinkov.jborngenerator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
@RequiredArgsConstructor
public class Producer {

    private final RandomWordsGeneratorService randomWordsGeneratorService;
    private static Boolean toggle = true;

    @Value("${kafka.topics.topic}")
    private String topic;

    private int messageNumber = 0;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessages() {
        try {
            while (toggle) {
                messageNumber++;
                String word = randomWordsGeneratorService.generatorWord();
                kafkaTemplate.send(topic, String.valueOf(ThreadLocalRandom.current().nextLong()), word);
                log.info("Отправлено сообщение номер {}", messageNumber);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
