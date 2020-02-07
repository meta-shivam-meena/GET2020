package com.metacube.eadSession5.view;

import com.metacube.eadSession5.model.User;

public class UserView implements View {
	private User user;

	public UserView(User user) {
		this.user = user;
	}

	public void view() {
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println(String.format("%-20s %-20s", "Id:", user.getId()));
		System.out
				.println(String.format("%-20s %-20s", "Name:", user.getName()));
		System.out.println(String.format("%-20s %-20s", "Email:",
				user.getEmail()));
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
