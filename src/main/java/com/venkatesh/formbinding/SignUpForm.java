package com.venkatesh.formbinding;

import org.springframework.stereotype.Repository;

@Repository
public class SignUpForm {
	private String Name;
	private String email;
	private Long  phno;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	

}
