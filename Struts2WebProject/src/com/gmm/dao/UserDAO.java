package com.gmm.dao;

import java.util.List;

import com.gmm.user.User;

public interface UserDAO {
	
	public boolean exist(User user);

	public void insert(User user);

	public List<User> select();

}
