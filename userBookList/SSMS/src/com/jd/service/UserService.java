package com.jd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.dao.UserDao;
import com.jd.model.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	public User findUserById(int id){
		return userDao.findUserById(id);
	}
	public Object[]  findAllUser(int pageNow,int everyPage){
		return userDao.findAllUser(pageNow,everyPage);
	}
	public int deleteUser(int id){
		return userDao.deleteUser(id);
	}
	public int insertUser(User user){
		return userDao.insertUser(user);
	}
}
