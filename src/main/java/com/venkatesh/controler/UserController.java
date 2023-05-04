package com.venkatesh.controler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.venkatesh.formbinding.LoginForm;
import com.venkatesh.formbinding.SignUpForm;
import com.venkatesh.formbinding.UnlockForm;
import com.venkatesh.serviceimpl.Userserviceimp;
@Controller
public class UserController {
	@Autowired
	private Userserviceimp userimp;
	
	
	
	@GetMapping("/login")
	public String login( Model model) {
		model.addAttribute("loginform", new LoginForm());
		return "login";
	}
	@PostMapping("/login")
	public String loginform(@ModelAttribute("loginform")LoginForm form,Model model ) {
		String status=userimp.login(form);
		if(status.contains("success")) {
			
			return "redirect:/dashboard";
		}
		model.addAttribute("errmsg",status);
		
		return "login";
	}
	
	
	@PostMapping("/signup")
	public String sign(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean istrue=userimp.signup(form);
		if(istrue) {
			model.addAttribute("sucess","account created goto check your mail");
		}else {
			model.addAttribute("error", "email should unique");
		}
		
		return "signup";
	}
    
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new SignUpForm());
		
		return "signup";
	}
	
	@GetMapping("/unlock")
	public String unlock(@RequestParam String email ,Model model ) {
		UnlockForm formobj=new UnlockForm();
		formobj.setEmail(email);
		model.addAttribute("unlock",formobj);
		return "unlock";
	}
	
	
	@PostMapping("/unlock")
	public String unlockform(@ModelAttribute("unlock")UnlockForm unlock ,Model model) {
		
			boolean status=userimp.unlock(unlock);
			if(status) {
				model.addAttribute("success","your account is unlock");
			}else {
				model.addAttribute("unsucess","temp password in-correct");
			}
			
		
		
		
		return "unlock";
	}
	
	@GetMapping("/pwd")
	public String password( ) {
		
		return "forgotPwd";
	}
	
	
	
	@PostMapping("/pwd")
	public String forgotpwd(@RequestParam("email")String email ,Model model) {
		String status=userimp.frogotpwd(email);
		if(status.equals("success")) {
		model.addAttribute("pwd","password is send to your mail check  onces");
		}
		model.addAttribute("error",status);
		
		return "forgotPwd";
	}
}
