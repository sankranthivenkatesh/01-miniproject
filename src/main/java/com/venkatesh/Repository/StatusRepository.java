package com.venkatesh.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venkatesh.entity.Enqurirystatus;

public interface StatusRepository extends JpaRepository<Enqurirystatus, Integer>{

	
	@Query("select distinct(Status_name) from Enqurirystatus")
	public List<String> getenquirystatus();
	
	
}
