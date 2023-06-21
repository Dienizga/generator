package com.shinkov.jborngenerator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shinkov.jborngenerator.service.RandomWordsGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RandomWordsController {
    private final RandomWordsGeneratorService service;

    @GetMapping("/words/send")
    public String sendWord() {
        return service.generatorWord();
    }

    @GetMapping("/words/sendM")
    public String createMessage() throws JsonProcessingException {
        log.info("create word request received");
        return service.send();
    }
}
