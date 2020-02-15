package com.metacube.eadSession5.view;

import java.util.List;

import com.metacube.eadSession5.model.User;

public class MultipleUsersView implements View {
	private List<User> users;

	public MultipleUsersView(List<User> users) {
		this.users = users;
	}

	public void view() {
		System.out.println();
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println(String.format("%-20s", "%-30s %-30s", "User Id", "Name", "Email"));
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (User user : users) {
			System.out.println(String.format("%-20s %-30s %-30s", user.getId(),
					user.getName(), user.getEmail()));
		}
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}