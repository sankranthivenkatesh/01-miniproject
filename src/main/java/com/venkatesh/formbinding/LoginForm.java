package com.venkatesh.formbinding;

import org.springframework.stereotype.Repository;

@Repository
public class LoginForm {
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", pwd=" + pwd + "]";
	}
	

}
