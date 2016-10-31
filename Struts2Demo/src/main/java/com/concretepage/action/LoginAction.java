package com.concretepage.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
@Action("/login")
@ResultPath(value="/")
@Result(name="success",location="login.jsp")
public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1025665697044131827L;

	public String execute() {
	    return SUCCESS;
	}
}