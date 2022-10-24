package com.loginAPI.service;

import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.stereotype.Service;

import com.loginAPI.properties.EmailProperties;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailAuthServiceImpl implements EmailAuthService{
	
	@Override
	public String emailAuth(String email) {
		String authCode = makeRandomNumber();
		if(isValidEmail(email)) { //이메일 유효성 체크
			sendMail("loginAPI의 이메일인증코드", authCode,email,EmailProperties.gmailId,EmailProperties.gmailPassword);
			return authCode;
		}

		return "It's not an appropriate email format";
	}
	
	private boolean isValidEmail(String email) {
		String format = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
		log.error("It's not an appropriate email format");
		return false;
	}

	public String makeRandomNumber() {
		String randomNumber = "";
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		for(int i = 0 ; i < 6 ; i ++) {
			randomNumber += random.nextInt(10);
		}
		return randomNumber;
	}
	
	public void sendMail(String subject, String authCode, String toMailAddress, String gmailId, String gmailPassword) {
		String fromMail = gmailId;
	    String fromName = "CertificationCode";
	    String toMail = toMailAddress; // 콤마(,) 나열 가능
	    
	    
	    // mail contents
	    StringBuffer contents = getContents(authCode);
	    // mail properties
	    Properties props = getmailProperties();
	   
	    Session mailSession = Session.getInstance(props,
	            new javax.mail.Authenticator() { // set authenticator
	                protected PasswordAuthentication getPasswordAuthentication() {
	                	return new PasswordAuthentication(gmailId, gmailPassword);
	                }
	            });

	    try {
	        MimeMessage message = new MimeMessage(mailSession);

	        message.setFrom(new InternetAddress(fromMail, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 한글의 경우 encoding 필요
	        message.setRecipients(
	            Message.RecipientType.TO, 
	            InternetAddress.parse(toMail)
	        );
	        message.setSubject(subject);
	        message.setContent(contents.toString(), "text/html;charset=UTF-8"); // 내용 설정 (HTML 형식)
	        message.setSentDate(new java.util.Date());

	        Transport t = mailSession.getTransport("smtp");
	        t.connect(gmailId, gmailPassword);
	        t.sendMessage(message, message.getAllRecipients());
	        t.close();
	        
	    } catch (Exception e) {
	    	log.error("Error sendMail");
	    }
	}

	private Properties getmailProperties() {
		 Properties props = new Properties();
		props.put("mail.smtp.host", EmailProperties.host); // use Gmail
		props.put("mail.smtp.port", EmailProperties.port); // set port

		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true"); // use TLS
		return null;
	}

	private StringBuffer getContents(String authCode) {
		 StringBuffer contents = new StringBuffer();
		   contents.append("<h1>이메일 인증코드</h1><br><br>");
		   contents.append("<p> 이메일 인증코드는 "+authCode+" 입니다.</p><br>");
		return contents;
	}
	
	
}