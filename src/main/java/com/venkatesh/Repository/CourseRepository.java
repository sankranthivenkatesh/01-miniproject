package com.venkatesh.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venkatesh.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Integer> {

	
	@Query("select distinct(CourseName) from Courses")
	public List<String> getcoursesdata();
	
	
}
