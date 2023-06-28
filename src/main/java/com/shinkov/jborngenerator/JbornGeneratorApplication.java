package com.shinkov.jborngenerator;

import com.shinkov.jborngenerator.producer.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JbornGeneratorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JbornGeneratorApplication.class, args);
        Producer producer = context.getBean(Producer.class);
        producer.sendMessages();
    }
}
