package com.metacube.eadSession7.mailSender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mockMailSender")
@Primary
public class MockMailSender implements MailSender {
	
	public void sendMail() {
		System.out.println("Mock Mail Sent.");
	}
}
