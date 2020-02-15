package com.metacube.eadSession5.facade;

import java.util.List;

import com.metacube.eadSession5.dao.UserDao;
import com.metacube.eadSession5.enums.Response;
import com.metacube.eadSession5.model.User;

public class UserFacade {
	private static UserFacade userFacade;
	private UserDao userDao;
	
	private UserFacade() {
		userDao = UserDao.getUserDao();
	}
	
	public static UserFacade getUserFacade() {
		if (userFacade == null) {
			userFacade = new UserFacade();
		}
		return userFacade;
	}
	
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public Response addUser(User user) {
		return userDao.addUser(user);
	}
	
	public Response updateUserId(int userId, int newUserId) {
		return userDao.updateUserId(userId, newUserId);
	}
	
	public Response updateUserName(int userId, String newName) {
		return userDao.updateUserName(userId, newName);
	}
	
	public Response updateUserEmail(int userId, String newEmail) {
		return userDao.updateUserEmail(userId, newEmail);
	}
	
	public Response deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}
	
	public Response deleteAllUsers() {
		return userDao.deleteAllUsers();
	}
	
	public boolean exits(int userId) {
		return userDao.exists(userId);
	}
}
