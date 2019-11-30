package com.Gary.service;

import com.Gary.dao.UserDao;
import com.Gary.domain.User;

public class UserService {

	private UserDao userDao;
	
	public boolean findUser(User user) {
	
		User temp = userDao.findUser(user);
		
		return temp == null?false:true;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
