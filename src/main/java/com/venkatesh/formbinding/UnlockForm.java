package com.venkatesh.formbinding;

import org.springframework.stereotype.Repository;

@Repository
public class UnlockForm {
	private String email;
	private String tpwd;
	private String newpwd;
	private String conpwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConpwd() {
		return conpwd;
	}
	public void setConpwd(String conpwd) {
		this.conpwd = conpwd;
	}
	@Override
	public String toString() {
		return "UnlockForm [email=" + email + ", tpwd=" + tpwd + ", newpwd=" + newpwd + ", conpwd=" + conpwd + "]";
	}
	

}
