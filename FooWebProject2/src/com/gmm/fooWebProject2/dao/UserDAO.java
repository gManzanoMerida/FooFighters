package com.gmm.fooWebProject2.dao;

import java.util.List;

import com.gmm.fooWebProject2.user.User;

public interface UserDAO {
	
	public boolean exist(User user);

	public void insert(User user);

	public List<User> select();

}
