package com.example;

import com.example.service.SendSmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class Springboot05BeginnerEmailApplicationTests {

    @Autowired
    private SendSmsService sendSmsService;

    @Test
    void contextLoads() {
        sendSmsService.sendMessage();
    }
    @Test
    void contextLoadss() throws MessagingException {
        sendSmsService.createAndSendMessage();
    }

}
