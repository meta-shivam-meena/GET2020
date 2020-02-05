package com.metacube.eadSession6_1_2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private boolean status;
	private String message;
	
	public Response(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
