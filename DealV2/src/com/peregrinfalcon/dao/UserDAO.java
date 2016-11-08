package com.peregrinfalcon.dao;

import com.peregrinfalcon.dto.User;

public class UserDAO {
	
	public User getUser(String userName, String pass){
		User user = new User();
		
		user.setCellPhone("612345678");
		user.setEmail("name1.lastname@aaa.com");
		user.setName("name1");
		user.setLastname("lastname");
		user.setPass("1234");
		user.setPhone("955555555");
		
		if (userName.equals(user.getName()) && pass.equals(user.getPass())){
			return user;
		} else {
			return null;
		}
		
	}

}
