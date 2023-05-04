package com.venkatesh.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatesh.Repository.UserRepository;
import com.venkatesh.entity.UserDetails;
import com.venkatesh.formbinding.LoginForm;
import com.venkatesh.formbinding.SignUpForm;
import com.venkatesh.formbinding.UnlockForm;
import com.venkatesh.service.UserService;
import com.venkatesh.util.Emailhelper;
import com.venkatesh.util.PasswordGenerate;



@Service
public class Userserviceimp implements UserService{
	@Autowired
	private UserRepository repository;
	@Autowired
	private Emailhelper emailhelper;
	@Autowired
	private HttpSession session;

	@Override
	public String login(LoginForm form) {
		
		
		UserDetails udetails=repository.findByPwd( form.getPwd());
		UserDetails udetails1=repository.findByEmail(form.getEmail());
		
		if(udetails==null) {
			return "invalid creditials";
		}
		
		if(udetails1==null) {
			return "invalid creditials";
		}
		
		if(udetails.getAccStatus().equals("locked")) {
			return "your account is locked";
		}
		
		session.setAttribute("userId", udetails.getUserId());
		return "success";
	}

	@Override
	public Boolean signup(SignUpForm form) {
		UserDetails user=repository.findByEmail(form.getEmail());
		
		if(user!=null) {
			return false;
		}
		UserDetails entity=new UserDetails();
		
		
		BeanUtils.copyProperties(form, entity);
		
		
		
		
		String pwd=PasswordGenerate.temppassword(6);
		entity.setPwd(pwd);
		
		entity.setAccStatus("locked");
		
		repository.save(entity);
		
		
		
		
		String to=form.getEmail();
		String subject="un lock your account";
		StringBuffer body=new StringBuffer("");
		body.append("<h1>use the below temporary pwd to unlock your account</H1>");
		body.append("tempory pwd:"+pwd);
		body.append("<a href=\"http://localhost:9097/unlock?email="+ to +"\" >click to unlock account");
		
		
		
		emailhelper.email(to, subject, body.toString());
		
		
		return true;
	}

	@Override
	public boolean unlock(UnlockForm form) {
		UserDetails entity=repository.findByEmail(form.getEmail());
		
		if(entity.getPwd().equals(form.getTpwd())){
			entity.setPwd(form.getNewpwd());
		  entity.setAccStatus("unlock");
		  repository.save(entity);
			return true;
			
		}else {
		return false;
		}
	}

	@Override
	public String frogotpwd(String email) {
	UserDetails user=repository.findByEmail(email);
	if(user==null) {
		return "invalid email";
	}
	
	String pwd=	user.getPwd();
	String sub="forgot password";
	StringBuffer body=new StringBuffer("");
	body.append("<h1>this is your password</h1>");
	body.append("your pwd:"+pwd);

	emailhelper.email(email, sub, body.toString());
		
		
		return "success";
	}

}
