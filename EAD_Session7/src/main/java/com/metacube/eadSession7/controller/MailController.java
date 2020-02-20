package com.metacube.eadSession7.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.eadSession7.mailSender.MailSender;

@RestController
public class MailController {
	
	//@Autowired
	//@Qualifier("mockMailSender")
	@Resource(name = "smtpMailSender")
	private MailSender mailSender;
	
	@Autowired
//	@Qualifier("smtpMailSender")
//	//@Resource(name = "smtpMailSender")	
//	public MailController(MailSender mailSender) {
//		this.mailSender = mailSender;
//		System.out.println("Constructor");
//	}

	public MailSender getMailSender() {
		return mailSender;
	}

	@Autowired
//	@Qualifier("smtpMailSender")
//	//@Resource(name = "smtpMailSender")
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
		System.out.println("Setter");
	}
	
	@GetMapping("/sendMail")
	public String sendMail() {
		mailSender.sendMail();
		return "Mail Sent";
	}
}
