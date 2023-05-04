package com.venkatesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.venkatesh.entity.CitizenPlan;

public interface reportservice extends JpaRepository<CitizenPlan, Integer>{
	@Query("select distinct(PLAN_NAME) from CitizenPlan")
	public List<String> getPlanName();
	
	@Query("select distinct(PLAN_STATUS) from CitizenPlan")
	public List<String> getPlanStatuse();
	
	
	
}
