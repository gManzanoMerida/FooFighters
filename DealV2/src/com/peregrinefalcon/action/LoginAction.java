package com.peregrinefalcon.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.peregrinfalcon.dao.UserDAO;
import com.peregrinfalcon.dto.User;

@Namespace("/user")
@Action("/login")
@ResultPath(value="/")
@Result(name="success",location="login.jsp")
public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1025665697044131827L;
	private String userName;
	private String pwd;

	private String mensaje;

	public String execute() { 
		this.setMensaje("SUCCESS");
	    return SUCCESS;
	}
	
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}