package com.concretepage.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
@ResultPath(value="/")
@Action(value="result", results={@Result(name="success",location="result.jsp"),
		@Result(name="error",location="error.jsp")})
public class ResultAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5257319436307656954L;
	private String userName;
	private String pwd;
	public String execute() {
		if(getUserName() !=null && getUserName().equals(getPwd())){
		   return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}