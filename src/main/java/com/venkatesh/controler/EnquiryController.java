package com.venkatesh.controler;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.venkatesh.Repository.StudentRepository;
import com.venkatesh.entity.StudentEnquries;

import com.venkatesh.formbinding.DashBoardresponse;
import com.venkatesh.formbinding.EnquiryForm;
import com.venkatesh.formbinding.EnquirySearch;
import com.venkatesh.serviceimpl.ennquiryStatusimp;



@Controller
public class EnquiryController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ennquiryStatusimp enqstatusimp;
	
	@Autowired
	private StudentRepository repo;
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		
		return "index";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(  Model model) {
		
		Integer userid=(Integer)session.getAttribute("userId");
		
		DashBoardresponse response=enqstatusimp.getdashboard(userid);
		
	model.addAttribute("dashboard", response);
		return "dashboard";
	}
	
	
     @GetMapping("/addenquiry")
	public String addenquiry(Model model) {
    	 init(model);
    	 model.addAttribute("addenquiry", new EnquiryForm());
    	 
    	 
		return "add-enquiry";
	}
     
     @PostMapping("/addenquiry")
 	public String addenquirys(@ModelAttribute("addenquiry")EnquiryForm form,Model model) {
    	 enqstatusimp.upsetenquiry(form);
    	 model.addAttribute("add","data added");
    	 init(model);
     	 
 		return "add-enquiry";
 	}
     
     
     
	@GetMapping("/enquiries")
	public String viewenquiry(Model model) {
		Integer userid=(Integer)session.getAttribute("userId");
		List<StudentEnquries> enquries=enqstatusimp.getenquiry();
		model.addAttribute("enquries", enquries);
		
		
		init(model);
		
		
		return "view-enquiries";
	}
	
	
	@GetMapping("/viewenquiries")
	public String viewenquirys(@RequestParam String cname,
			@RequestParam	String status,  @RequestParam String mode, Model model) {
		EnquirySearch search=new EnquirySearch();
		search.setCourse_name(cname);
		search.setEnquiry_Status(status);
		search.setCourse_mode(mode);
		Integer userid=(Integer)session.getAttribute("userId");
		List<StudentEnquries> enqurie=enqstatusimp.getenquirysearch(userid, search);
		model.addAttribute("enquries", enqurie);

		
		return "view-enquiries";
	}
	
	@GetMapping("/edit/{Studentid}")
	public String editdata(@PathVariable("Studentid") Integer sid,Model model,EnquiryForm form) {
		
		Optional<StudentEnquries> e1=repo.findById(sid);
         if(e1.isPresent()) {
        	 StudentEnquries pro=e1.get();
        	
        	 model.addAttribute("addenquiry" ,pro);
        	 System.out.println(pro.getStudentid());
        	 init(model);
         }
	  return "add-enquiry";
	}
	
	private void init(Model model) {
		model.addAttribute("search",new EnquiryForm  ());
		model.addAttribute("getcourses",enqstatusimp.getcourses());
	    model.addAttribute("statues",enqstatusimp.status());
	}
	
}
