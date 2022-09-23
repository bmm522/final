package com.loginAndSignUpForm.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestMailRun {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private String RandomNumber = "";
	
    @Value("${spring.mail.username}")
    private String managerEmail;

    
    public void run(JavaMailSender mailSender) throws Exception{
    	this.mailSender = mailSender;
    	CreateRandomNumber crn = new CreateRandomNumber();
    	this.RandomNumber = crn.makeRandomNumber();
    	MimeMessage m = mailSender.createMimeMessage();
        MimeMessageHelper h = new MimeMessageHelper(m,"UTF-8");
		h.setFrom(managerEmail);
		h.setTo("rlawldls11@naver.com");
	    h.setSubject("테스트메일");
	    h.setText(RandomNumber);
        
        mailSender.send(m);
        
        
    }
    
    public String getRandomNumber() {
    	return RandomNumber;
    }
}
