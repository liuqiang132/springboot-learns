package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot05BeginnerEmailApplication {

    public static final Logger logger = LoggerFactory.getLogger(Springboot05BeginnerEmailApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Springboot05BeginnerEmailApplication.class, args);
        logger.info("=========info--message====");
        logger.info("=========info--message====");
        logger.info("=========info--message====");
        logger.debug("=========debug--message====");
        logger.debug("=========debug--message====");
        logger.debug("=========debug--message====");

    }

}
