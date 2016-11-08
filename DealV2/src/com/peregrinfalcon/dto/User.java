package com.peregrinfalcon.dto;

public class User {
	
	private String name;
	private String lastname;
	private String pass;
	private String email;
	private String phone;
	private String cellPhone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", pass=" + pass + ", email=" + email + ", phone=" + phone + ", cellPhone="
				+ cellPhone + "]";
	}
	
	

}
