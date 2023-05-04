package com.venkatesh.service;

import com.venkatesh.formbinding.LoginForm;
import com.venkatesh.formbinding.SignUpForm;
import com.venkatesh.formbinding.UnlockForm;

public interface UserService {
	
	
	public String login(LoginForm form);
	public Boolean signup(SignUpForm form);
	public boolean unlock(UnlockForm form);
	public String frogotpwd(String email);

}
