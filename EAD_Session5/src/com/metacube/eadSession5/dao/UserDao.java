package com.metacube.eadSession5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.model.User;

public class UserDao {
	private static UserDao userDao;
	private Map<Integer, User> userIdAndUserPairs;
	
	private UserDao() {
		userIdAndUserPairs = new HashMap<Integer, User>();
	}
	
	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}
	
	public Response addUser(User user) {
		if (user == null) {
			return Response.INVALID_USER;
		} else {
			if (userIdAndUserPairs.containsKey(user.getId())) {
				return Response.DUPLICATE_USER_ID;
			} else {
				userIdAndUserPairs.put(user.getId(), user);
				return Response.SUCCESS;
			}
		}
	}
	
	public Response deleteUser(int userId) {
		if (userIdAndUserPairs.containsKey(userId)) {
			userIdAndUserPairs.remove(userId);
			return Response.SUCCESS;
		} else {
			return Response.USER_NOT_FOUND;
		}
	}
	
	public boolean exists(int userId) {
		if (userIdAndUserPairs.containsKey(userId)) {
			return true;
		} else {
			return false;
		}
	}
	
	public User getUser(int userId) {
		return userIdAndUserPairs.get(userId);
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<User>(userIdAndUserPairs.values());
	}
	
	public Response updateUserId(int userId, int newUserId) {
		if (userIdAndUserPairs.containsKey(userId)) {
			if (userIdAndUserPairs.containsKey(newUserId)) {
				return Response.DUPLICATE_USER_ID;
			} else {
				User user = userIdAndUserPairs.get(userId);
				userIdAndUserPairs.remove(userId);
				user.setId(newUserId);
				userIdAndUserPairs.put(newUserId, user);
				return Response.SUCCESS;
			}
		} else {
			return Response.USER_NOT_FOUND;
		}
	}
	
	public Response updateUserName(int userId, String newName) {
		if (userIdAndUserPairs.containsKey(userId)) {
			User user = userIdAndUserPairs.get(userId);
			user.setName(newName);
			return Response.SUCCESS;
		} else {
			return Response.USER_NOT_FOUND;
		}
	}
	
	public Response updateUserEmail(int userId, String newEmail) {
		if (userIdAndUserPairs.containsKey(userId)) {
			User user = userIdAndUserPairs.get(userId);
			user.setEmail(newEmail);
			return Response.SUCCESS;
		} else {
			return Response.USER_NOT_FOUND;
		}
	}
}
