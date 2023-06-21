package com.shinkov.jborngenerator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    @Value("${topic.name}")
    private String orderTopic;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(String str) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(str);
        kafkaTemplate.send(orderTopic, orderAsMessage);
        log.info("Word is produced {}", orderAsMessage);
        return "message sent";
    }
}
