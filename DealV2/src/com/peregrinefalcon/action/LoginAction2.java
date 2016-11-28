package com.peregrinefalcon.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.peregrinfalcon.dao.UserDAO;
import com.peregrinfalcon.dto.User;

@Namespace("/user")
@ResultPath(value="/")
//@Action("/login2",  results={@Result(name="success",location="result.jsp"),
//		@Result(name="error",location="error.jsp")})
@Result(name="success",location="login2.jsp") 
public class LoginAction2 extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1025665697044131827L;
	private String userName;
	private String pwd;

	public String execute() { 
	    return SUCCESS;
	}
}