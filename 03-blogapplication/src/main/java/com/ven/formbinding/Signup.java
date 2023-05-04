package com.ven.formbinding;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Repository
public class Signup {
	
     private String fname;
	
	private String lname;
	
	private String pwd;
	
	private String email;
}
