package com.jd.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.dao.UserDao;
import com.jd.mapper.UserMapper;
import com.jd.model.User;
import com.jd.util.Page;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private User user;
	@Autowired
    private UserMapper userMapper;
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		user=userMapper.selectUserById(id);
		return user;
	}
	
	@Override
	public Object[] findAllUser(int pageNow,int everyPage) {
		// TODO Auto-generated method stub
		int totalCount=userMapper.selectCount();
		Page page=new Page();
		page.setTotalCount(totalCount);
		page.setPageNow(pageNow);
		page.setEveryPage(everyPage);
		page.init();
		Map<String , Object> map=new HashMap<String, Object>();
		map.put("beginStart", page.getBeginStart());
		map.put("everyPage", page.getEveryPage());
		Object[] objects=new Object[]{page.getTotalPage(),userMapper.selectAllUser(map)};
		return objects;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		
		return userMapper.deleteUser(id);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		
		return userMapper.insertUser(user);
	}



}
