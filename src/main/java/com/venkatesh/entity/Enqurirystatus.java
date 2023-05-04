package com.venkatesh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Enqurirystatus {
	@Id
	private Integer EnqId;
	private String Status_name;
	public Integer getEnqId() {
		return EnqId;
	}
	public void setEnqId(Integer enqId) {
		EnqId = enqId;
	}
	public String getStatus_name() {
		return Status_name;
	}
	public void setStatus_name(String status_name) {
		Status_name = status_name;
	}
	
	

}
