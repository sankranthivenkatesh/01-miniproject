package com.venkatesh.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatesh.Repository.CourseRepository;
import com.venkatesh.Repository.StatusRepository;
import com.venkatesh.Repository.StudentRepository;
import com.venkatesh.Repository.UserRepository;
import com.venkatesh.entity.StudentEnquries;
import com.venkatesh.entity.UserDetails;
import com.venkatesh.formbinding.DashBoardresponse;
import com.venkatesh.formbinding.EnquiryForm;
import com.venkatesh.formbinding.EnquirySearch;
import com.venkatesh.service.EnquiryStatus;


@Service
public class ennquiryStatusimp implements EnquiryStatus{
	
	
    @Autowired
	private StudentRepository studentrepository;
    
	@Autowired
    private CourseRepository   courserepo;
	
    @Autowired
	private StatusRepository   statusrep;
	@Autowired
    private UserRepository userrepo;
	@Autowired
    private HttpSession session;
    
	@Override
	public List<String> getcourses() {
		List<String> courses=courserepo.getcoursesdata();
		return  courses;
	}

	@Override
	public List<String> status() {
		List<String> s=statusrep.getenquirystatus();
		return s;
	}

	@Override
	public DashBoardresponse getdashboard(Integer userid) {
		DashBoardresponse response=new DashBoardresponse();
	Optional<UserDetails> entity=userrepo.findById(userid);
		if(entity.isPresent()) {
			UserDetails userentity=entity.get();
			List<StudentEnquries> enquries=userentity.getStdenq();
			
		Integer totalenquries=	enquries.size();
			Integer  enrolledcnt=enquries.stream().filter(e->e.getEnquiry_Status().equals("enrolled")).collect(Collectors.toList()).size();
			
			Integer lostcnt=enquries.stream().filter(e->e.getEnquiry_Status().equals("lost")).collect(Collectors.toList()).size();
			response.setTotalenq(totalenquries);
			response.setEnrolled(enrolledcnt);
			response.setLost(lostcnt);
			
		}
		
		
		
		return response;
	}

	@Override
	public boolean upsetenquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		StudentEnquries add= new StudentEnquries();
		BeanUtils.copyProperties(form,add);
		Integer userId=(Integer)session.getAttribute("userId");
		UserDetails userentity=userrepo.findById(userId).get();
		add.setUserid(userentity);
		
		
		studentrepository.save(add);
		
		
		
		return true ;
	}

	@Override
	public List<StudentEnquries> getenquirysearch(Integer userid, EnquirySearch search) {
		Integer userId=(Integer)session.getAttribute("userId");
		Optional<UserDetails> userentity=userrepo.findById(userid);
		if(userentity.isPresent()) {
			UserDetails userdetails=userentity.get();
			List<StudentEnquries> enquries=userdetails.getStdenq();
			if(null!=search.getCourse_name() && !"".equals(search.getCourse_name())) {
				
				enquries=enquries.stream().filter(e->e.getCourse_name().equals(search.getCourse_name())).collect(Collectors.toList());
			}
			
           if(null!=search.getCourse_mode() && !"".equals(search.getCourse_mode())) {
				
				enquries=enquries.stream().filter(e->e.getCourse_mode().equals(search.getCourse_mode())).collect(Collectors.toList());
			}
           if(null!=search.getEnquiry_Status() && !"".equals(search.getEnquiry_Status())) {
				
				enquries=enquries.stream().filter(e->e.getEnquiry_Status().equals(search.getEnquiry_Status())).collect(Collectors.toList());
			}
           return enquries;
           
		}
			
			
		return null;
	}

	@Override
	public List<StudentEnquries> getenquiry() {
		Integer userId=(Integer)session.getAttribute("userId");
	Optional<UserDetails> userentity=userrepo.findById(userId);
	if(userentity.isPresent()) {
		UserDetails userdetails=userentity.get();
		List<StudentEnquries> enquries=userdetails.getStdenq();
		return enquries;
		
	}
	
		return null;
	}

}
