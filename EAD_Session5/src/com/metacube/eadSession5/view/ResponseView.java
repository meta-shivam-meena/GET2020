package com.metacube.eadSession5.view;

import com.metacube.eadSession5.enums.Response;

public class ResponseView implements View {
	private Response response;
	
	public ResponseView(Response response) {
		this.response = response;
	}
	
	public void view() {
		System.out.println();
		System.out.println(response.name());
		System.out.println();
	}
}
