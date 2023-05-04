package com.ven.userservicesimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ven.entity.User;
import com.ven.formbinding.Login;
import com.ven.formbinding.Signup;
import com.ven.repositorys.Userrepository;
import com.ven.userservices.Userservices;


@Service
public class UserServicesimple implements Userservices {

	@Autowired
	private Userrepository rep;
	 
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean signup(Signup form) {
		
		
		User entity=new User();
		BeanUtils.copyProperties(form, entity);
		rep.save(entity);
		return true;
	}

	@Override
	public String login(Login form) {
	User entity=rep.findByPwd(form.getPwd());
	User entity1=rep.findByEmail(form.getEmail());
		if(entity==null) {
			return "invalid credentials";
		}
		if(entity1==null) {
			return "invalid credentials";
		}
		
		session.setAttribute("userid",entity.getUserid());
		
		
		return "success";
	}

}
