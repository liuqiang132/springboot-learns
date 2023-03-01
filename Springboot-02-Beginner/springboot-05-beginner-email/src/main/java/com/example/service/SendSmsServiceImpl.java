package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendSmsServiceImpl implements SendSmsService {


    @Autowired
    private JavaMailSender javaMailSender;

    private static final String from = "liu1325921@yeah.net";
    private static final String to = "liu1325921@yeah.net";
    private static final String subject = "测试邮件---解鲁瑶";
    private static final String context = "<a href='https://www.hao123.com'>点开有惊喜</a>";

    /**
     * 发送邮件功能
     * send发送
     */
    @Override
    public void sendMessage() {

        SimpleMailMessage message = new SimpleMailMessage();
        //发送人
        message.setFrom(from);
        //接收人
        message.setTo(to);
        //邮件标题
        message.setSubject(subject);
        //邮件正文内容
        message.setText(context);
        javaMailSender.send(message);

    }

    /**
     * 发送多个邮件
     * @throws MessagingException
     */

    @Override
    public void createAndSendMessage() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        //解析正文内容的html
        messageHelper.setText(context,true);
        //发送文件
        File file = new File("C:\\Users\\liuqianh132\\Desktop\\Springboot-02-Beginner\\springboot-05-beginner-email\\target\\springboot-05-beginner-email-0.0.1-SNAPSHOT.jar");
        messageHelper.addAttachment(file.getName(),file);
        javaMailSender.send(message);
    }
}
