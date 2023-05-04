package com.venkatesh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.Data;

@Entity
@Data
public class UserDetails {
	@Id
	@GeneratedValue
	private Integer UserId;
	private String Name;
	private String email;
	private String pwd;
	private Long phno;
	private String accStatus;
	
	@OneToMany(mappedBy = "userid" ,cascade = CascadeType.ALL ,fetch=FetchType.EAGER)
	
	private List<StudentEnquries> stdenq;

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public List<StudentEnquries> getStdenq() {
		return stdenq;
	}

	public void setStdenq(List<StudentEnquries> stdenq) {
		this.stdenq = stdenq;
	}

	@Override
	public String toString() {
		return "UserDetails [UserId=" + UserId + ", Name=" + Name + ", email=" + email + ", pwd=" + pwd + ", phno="
				+ phno + ", accStatus=" + accStatus + "]";
	}

	

	
	
}
