package com.LoginAndSignUp.SignUp.email.API;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class GmailAPI {
	
	
	public static void sendMail(String subject, String  content, String toMailAddress, String gmailId, String password) {
		
	    System.out.println("Start JavaMail API Test ~!");

//	    String subject = "이메일 인증코드";
	    String fromMail = gmailId;
	    String fromName = "CertificationCode";
	    String toMail = toMailAddress; // 콤마(,) 나열 가능

	    // mail contents
	    StringBuffer contents = new StringBuffer();
	    contents.append("<h1>이메일 인증코드입니다.</h1>\n");
	    contents.append("<p>"+content+"</p><br>");

	    // mail properties
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com"); // use Gmail
	    props.put("mail.smtp.port", "587"); // set port

	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true"); // use TLS

	    Session mailSession = Session.getInstance(props,
	            new javax.mail.Authenticator() { // set authenticator
	                protected PasswordAuthentication getPasswordAuthentication() {
	                	return new PasswordAuthentication(gmailId, password);
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
	        t.connect(gmailId, password);
	        t.sendMessage(message, message.getAllRecipients());
	        t.close();

	        System.out.println("Done Done ~!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
