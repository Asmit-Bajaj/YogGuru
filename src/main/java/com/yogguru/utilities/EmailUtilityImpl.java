package com.yogguru.utilities;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class EmailUtilityImpl implements EmailUtility {

	// send the desired content to given email address
	public boolean sendEmail(String emailAddress, String content,String subject) {
		boolean flag = false;
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		final String username = "eduhitec.004@gmail.com";
		final String password = "EduHITec";

		Session session_ = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// -- Create a new message --
		Message msg = new MimeMessage(session_);

		// -- Set the FROM and TO fields --
		try {
			msg.setFrom(new InternetAddress("YogGuru"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress, false));
			msg.setSubject(subject);
			msg.setContent(content, "text/html");
			msg.setSentDate(new Date());

			Transport.send(msg);
			flag = true;
		} catch (Exception e) {
			System.out.println("Exception at sendEmail() : "+e);
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

}
