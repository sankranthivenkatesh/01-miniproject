package com.ven.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Table(name="user_tbl")
public class User {
	
	@Id
	@GeneratedValue
	private Integer userid;
	
	
	private String fname;
	
	private String lname;
	
	private String pwd;
	
	private String email;

}
