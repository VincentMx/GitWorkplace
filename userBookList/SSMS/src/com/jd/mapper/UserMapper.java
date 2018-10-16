package com.jd.mapper;

import java.util.List;
import java.util.Map;

import com.jd.model.User;

public interface UserMapper {
	public User selectUserById(int id);//查询用户
    public List<User> selectAllUser(Map<String, Object> map);
    public int deleteUser(int id);
    public int insertUser(User user);
    public int selectCount();
}
