package com.venkatesh.contrler;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.venkatesh.entity.CitizenPlan;
import com.venkatesh.formbinding.Formbinding;
import com.venkatesh.service.Service;

@Controller
public class servicecontroller {
	
	@Autowired
	private Service service;
	
	@GetMapping("/excel")
	public void excelexport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");
		service.exportexcel(response);
	}
	
	
	@GetMapping("/pdf")
	public void Pdfexport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
		service.exportpdf(response);
	}
	
	@PostMapping("/search")
	public String search( Formbinding request, Model model) {
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("p", plans);
		init(model);
		model.addAttribute("search",request);
		
		return "index";
		
	}
	
	@GetMapping("/")
	public String indexpage(Model model) {

		init(model);
		
	    return "index";
	
	}

	private void init(Model model) {
		model.addAttribute("search",new  Formbinding());
		model.addAttribute("plannames",service.getplanname());
	    model.addAttribute("planstatuses",service.getplanstatus());
	}

}
