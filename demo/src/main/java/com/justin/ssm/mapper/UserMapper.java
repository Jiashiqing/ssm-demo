package com.justin.ssm.mapper;

import com.justin.ssm.po.User;

import java.util.List;


/**
 * 
 * @author Administrator
 *
 */
public interface UserMapper {

	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String username) throws Exception;
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id)throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user)throws Exception;
	
	
}
