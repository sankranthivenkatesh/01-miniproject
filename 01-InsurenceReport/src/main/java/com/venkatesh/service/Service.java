package com.venkatesh.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.venkatesh.entity.CitizenPlan;
import com.venkatesh.formbinding.Formbinding;


public interface Service {
	public List<String> getplanname();
	public List<String> getplanstatus();
	public boolean exportexcel(HttpServletResponse response)throws Exception;
	public boolean exportpdf(HttpServletResponse response)throws Exception;
	public List<CitizenPlan> search(Formbinding request);
	
	

}
