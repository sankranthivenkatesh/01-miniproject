package com.ven.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Enquriescontroler {
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		
		return "dashboard";
	}

}
