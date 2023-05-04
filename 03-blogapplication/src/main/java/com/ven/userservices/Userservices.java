package com.ven.userservices;

import com.ven.formbinding.Login;
import com.ven.formbinding.Signup;

public interface Userservices {
	
	public boolean signup(Signup form);
	public String login(Login form);

}
