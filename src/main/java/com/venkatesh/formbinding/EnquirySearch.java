package com.venkatesh.formbinding;

import org.springframework.stereotype.Repository;

@Repository
public class EnquirySearch {
	
	private String Course_mode;
	private String Course_name;
	private String Enquiry_Status;
	private String enqdate;
	public String getCourse_mode() {
		return Course_mode;
	}
	public void setCourse_mode(String course_mode) {
		Course_mode = course_mode;
	}
	public String getCourse_name() {
		return Course_name;
	}
	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}
	public String getEnquiry_Status() {
		return Enquiry_Status;
	}
	public void setEnquiry_Status(String enquiry_Status) {
		Enquiry_Status = enquiry_Status;
	}
	public String getEnqdate() {
		return enqdate;
	}
	public void setEnqdate(String enqdate) {
		this.enqdate = enqdate;
	}
	

}
