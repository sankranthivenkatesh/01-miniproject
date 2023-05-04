package com.venkatesh.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class StudentEnquries {
	@Id
	@GeneratedValue
	private Integer Studentid;
	private String  StudentName;
	private Long phno;
	private String Course_mode;
	private String Course_name;
	private String Enquiry_Status;
	@CreationTimestamp
	private LocalDate Created_date;
	@UpdateTimestamp
	private LocalDate Update_date;
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid")
	private UserDetails userid;

	public Integer getStudentid() {
		return Studentid;
	}

	public void setStudentid(Integer studentid) {
		Studentid = studentid;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

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

	public LocalDate getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		Created_date = created_date;
	}

	public LocalDate getUpdate_date() {
		return Update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		Update_date = update_date;
	}

	

	

	public UserDetails getUserid() {
		return userid;
	}

	public void setUserid(UserDetails userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "StudentEnquries [Studentid=" + Studentid + ", StudentName=" + StudentName + ", phno=" + phno
				+ ", Course_mode=" + Course_mode + ", Course_name=" + Course_name + ", Enquiry_Status=" + Enquiry_Status
				+ ", Created_date=" + Created_date + ", Update_date=" + Update_date + "]";
	}

	
}
