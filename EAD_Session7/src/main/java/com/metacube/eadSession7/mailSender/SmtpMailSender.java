package com.metacube.eadSession7.mailSender;

import org.springframework.stereotype.Component;

@Component("smtpMailSender")
public class SmtpMailSender implements MailSender{
	
	public void sendMail() {
		System.out.println("Smtp Mail Sent.");
	}
}
