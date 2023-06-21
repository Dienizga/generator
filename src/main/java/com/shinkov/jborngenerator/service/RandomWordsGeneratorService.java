package com.shinkov.jborngenerator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomWordsGeneratorService {
    private final Producer producer;

    public String generatorWord() {
        return RandomStringUtils.randomAlphabetic(1, 101);
    }

    public String send() throws JsonProcessingException {
        return producer.sendMessage(generatorWord());
    }
}
