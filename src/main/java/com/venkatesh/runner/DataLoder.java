package com.venkatesh.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.venkatesh.Repository.CourseRepository;
import com.venkatesh.Repository.StatusRepository;
import com.venkatesh.entity.Courses;
import com.venkatesh.entity.Enqurirystatus;
@SpringBootApplication
public class DataLoder implements ApplicationRunner{
	
	
@Autowired	
private	StatusRepository statusrepo;
	
	
@Autowired	
 private CourseRepository courserepo;

    
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		statusrepo.deleteAll();
		courserepo.deleteAll();
		
		Courses c1=new Courses();
		c1.setCourseId(101);
		c1.setCourseName("fullstack java");
		Courses c2=new Courses();
		c2.setCourseId(102);
		c2.setCourseName("aws");
		Courses c3=new Courses();
		c3.setCourseId(103);
		c3.setCourseName("testing");
		
		List<Courses> cs=Arrays.asList(c1,c2,c3);
		
		courserepo.saveAll(cs);
		
		
		Enqurirystatus s1=new Enqurirystatus();
		s1.setEnqId(111);
		s1.setStatus_name("new");
		
		Enqurirystatus s2=new Enqurirystatus();
		s2.setEnqId(112);
		s2.setStatus_name("enrolled");
		Enqurirystatus s3=new Enqurirystatus();
		s3.setEnqId(113);
		s3.setStatus_name("lost");
		
		List<Enqurirystatus> enstatus=Arrays.asList(s1,s2,s3);
		
		statusrepo.saveAll(enstatus);
	}
	
}
	

