package com.ven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ven.formbinding.Login;
import com.ven.formbinding.Signup;
import com.ven.userservicesimpl.UserServicesimple;

@Controller
public class Registercontroller {
	
	
	@Autowired
	private UserServicesimple services;
	
	
	
	@GetMapping("/")
	public String indexpage()
	{
		return "index";
	}
	
	@GetMapping("/signup")
	public String registration(Model model) {
		
		model.addAttribute("sign", new Signup() );
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String register(@ModelAttribute("sign")Signup form, Model model) {
		boolean issaved=services.signup(form);
		if(issaved){
			model.addAttribute("msg", "sucessfull");
		}
		else {
		model.addAttribute("errmsg", "failed" );
		}
		return "signup";
	}
	
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}
	@PostMapping("/login")
	public String logins(@ModelAttribute("login")Login form,Model model) {
	String status=services.login(form);
	if(status.contains("success")) {
		
		return "redirect:/dashboard";
	}
	model.addAttribute("errmsg",status);
	return "login";
	}
}
