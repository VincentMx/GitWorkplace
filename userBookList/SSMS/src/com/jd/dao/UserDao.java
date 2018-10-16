package com.jd.dao;


import com.jd.model.User;

public interface UserDao {
	public User findUserById(int id);//查询一个用户信息
	public Object[]  findAllUser(int pageNow,int everyPage);
	public int deleteUser(int id);
	public int insertUser(User user);
}
