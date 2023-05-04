package com.venkatesh.service;

import java.util.List;

import com.venkatesh.entity.Courses;
import com.venkatesh.entity.Enqurirystatus;
import com.venkatesh.entity.StudentEnquries;
import com.venkatesh.formbinding.DashBoardresponse;
import com.venkatesh.formbinding.EnquiryForm;
import com.venkatesh.formbinding.EnquirySearch;

public interface EnquiryStatus {
	public List<String> getcourses();
	public List<String> status();
	public DashBoardresponse getdashboard(Integer userid);
	public boolean upsetenquiry(EnquiryForm form);
	public List<StudentEnquries> getenquirysearch(Integer userid,EnquirySearch search);
    public  List<StudentEnquries> getenquiry();
}
