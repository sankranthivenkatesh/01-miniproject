package com.venkatesh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


	@Entity
	@Data
	public class Courses {
		@Id
	
		private Integer CourseId;
		private String CourseName;
		public Integer getCourseId() {
			return CourseId;
		}
		public void setCourseId(Integer courseId) {
			CourseId = courseId;
		}
		public String getCourseName() {
			return CourseName;
		}
		public void setCourseName(String courseName) {
			CourseName = courseName;
		}


}
