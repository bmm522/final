package com.LoginAndSignUp.SignUp.email.API;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NaverMailAPI {
	/** 메일 HOST **/
	private static final String HOST = "smtp.naver.com";
	/** 메일 PORT **/
	private static final String PORT = "465";
	/** 메일 ID **/
	private static final String MAIL_ID = "bmm522@naver.com";
	/** 메일 PW **/
	private static final String MAIL_PW = "tkfkd!2dlquf!2";
	
	public static void sendMail(String subejct, String body, Object obj) {
		try {
			
			InternetAddress[] receiverList = new InternetAddress[1];
			receiverList[0] = new InternetAddress((String)obj);
			
			
			// SMTP 발송 Properties 설정
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", NaverMailAPI.HOST);
			props.put("mail.smtp.port", NaverMailAPI.PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.enable","true");
			props.put("mail.smtp.ssl.trust", NaverMailAPI.HOST);
			props.put("mail.smtp.auth", "true");
			
			// SMTP Session 생성
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(NaverMailAPI.MAIL_ID, NaverMailAPI.MAIL_PW);
				}
			});
			
			// Mail 조립
			Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.setFrom(new InternetAddress(NaverMailAPI.MAIL_ID));
			mimeMessage.setRecipients(Message.RecipientType.TO, receiverList);
            // 메일 제목
			mimeMessage.setSubject(subejct);
            // 메일 본문 (.setText를 사용하면 단순 텍스트 전달 가능)
			mimeMessage.setContent(body, "text/html; charset=UTF-8");
			
			// Mail 발송
			Transport.send(mimeMessage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
