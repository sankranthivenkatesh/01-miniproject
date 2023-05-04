package com.venkatesh.impl;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import com.venkatesh.entity.CitizenPlan;
import com.venkatesh.formbinding.Formbinding;
import com.venkatesh.repo.reportservice;
import com.venkatesh.service.Service;
import com.venkatesh.util.Emailfetch;
import com.venkatesh.util.Excelexport;
import com.venkatesh.util.Pdfexport;
@Repository
public class Serviceimpl implements Service {
	@Autowired
    private reportservice  repos;
	@Autowired
	private Excelexport export;
	@Autowired
	private Pdfexport pdfexport;
	
	@Autowired
	private Emailfetch email;	
	
	@Override
	public List<String> getplanname() {
		// TODO Auto-generated method stub
		List<String> plan= repos.getPlanName();
		return plan;
	}

	@Override
	public List<String> getplanstatus() {
		// TODO Auto-generated method stub
		List<String> status=repos.getPlanStatuse();
		return status;
	}

	@Override
	public boolean exportexcel(HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		File f=new File("plans.xls");
		
		List<CitizenPlan> plans=repos.findAll();
		export.excelgenerator(response,plans);
		String subject="text mail sender";
		String body="<h1>text mail body</h1>";
		String to="venkateshsankranthi26@gmail.com";
		
		
		email.emailsender(subject, to, body,f);
		
		
		f.delete();
		return true;
	}

	@Override
	public boolean exportpdf(HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		File f=new File("plans.pdf");
		
		List<CitizenPlan> plans=repos.findAll();
		pdfexport.pdfgenerator(response,plans,f);
		String subject="text mail sender";
		String body="<h1>text mail body</h1>";
		String to="venkateshsankranthi26@gmail.com";
		
		email.emailsender(subject, to, body, f);
		f.delete();
		return true;
	}

	@Override
	public List<CitizenPlan> search(Formbinding request) {
		
		// TODO Auto-generated method stub
		CitizenPlan cs=new CitizenPlan();
CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPLAN_NAME() && !"".equals(request.getPLAN_NAME())) {
			entity.setPLAN_NAME(request.getPLAN_NAME());
		}
		
		if(null!=request.getPLAN_STATUS() && !"".equals(request.getPLAN_STATUS())) {
			entity.setPLAN_STATUS(request.getPLAN_STATUS());
		}
		
		if(null!=request.getGENDER() && !"".equals(request.getGENDER())) {
			entity.setGENDER(request.getGENDER());
		}
		
		if(null!=request.getPLAN_START_DATE() && !"".equals(request.getPLAN_START_DATE())) {
			String startdate = request.getPLAN_START_DATE();
			System.out.println("Starting date "+startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			//converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate,date);
			System.out.println("local date " +localdate);
			
			entity.setPLAN_START_DATE(localdate);
		}
		
		if(null!=request.getPLAN_END_DATE() && !"".equals(request.getPLAN_END_DATE())) {
			String startdate = request.getPLAN_END_DATE();
			System.out.println("Starting date "+startdate);
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			//converting String to LocalDate
			LocalDate localdate = LocalDate.parse(startdate,date);
			System.out.println("local date " +localdate);
			
			entity.setPLAN_END_DATE(localdate);
		}
	     return repos.findAll(Example.of(entity));
		
	}

}
