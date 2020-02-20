package com.metacube.eadSession7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.eadSession7.mailSender.MailSender;
import com.metacube.eadSession7.mailSender.MockMailSender;
import com.metacube.eadSession7.mailSender.SmtpMailSender;

@Configuration
public class AppConfig {

	/*@Bean("smtpMailSender")
	public MailSender getSmtpMailSender() {
		return new SmtpMailSender();
	}
	
	@Bean("mockMailSender")
	@Primary
	public MailSender getMockMailSender() {
		return new MockMailSender();
	}*/
}
