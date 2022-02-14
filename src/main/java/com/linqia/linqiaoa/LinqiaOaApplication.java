package com.linqia.linqiaoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LinqiaOaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LinqiaOaApplication.class, args);
        context.getBean(KeywordService.class).loadKeywordInMemory();
    }

}
