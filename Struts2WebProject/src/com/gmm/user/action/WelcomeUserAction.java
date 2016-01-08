package com.gmm.user.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.gmm.dao.JDBCUserDAO;
import com.gmm.user.User;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/User")
@ResultPath(value = "/")
public class WelcomeUserAction extends ActionSupport {

	private static final long serialVersionUID = -8304690402795165493L;
	
	private String username; 


	@Action(value = "Welcome", results = { @Result(name = "success", location = "pages/welcome_user.jsp") })
	public String execute() {

		return SUCCESS;

	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

 
}