package com.ven.formbinding;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Repository
public class Login {
	
    private String pwd;
	
	private String email;     

}
