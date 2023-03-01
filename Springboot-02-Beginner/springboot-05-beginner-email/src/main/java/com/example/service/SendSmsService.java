package com.example.service;

import javax.mail.MessagingException;

public interface SendSmsService {


     void  sendMessage();
     void  createAndSendMessage() throws MessagingException;
}
