package com.venkatesh.entity;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class CitizenPlan {
	
	@Id
	@GeneratedValue
	private Integer CITIZEN_ID;
	private String CITIZEN_NAME;
	private String GENDER;
	private String PLAN_NAME;
	private String PLAN_STATUS;
	private LocalDate PLAN_START_DATE;
	private LocalDate PLAN_END_DATE;
	private Integer BENEFIT_AMOUNT;
	private String DENIAL_REASON;
	private LocalDate TERMINATED_DATE;
	private String TERMINATION_REASON;
	public Integer getCITIZEN_ID() {
		return CITIZEN_ID;
	}
	public void setCITIZEN_ID(Integer cITIZEN_ID) {
		CITIZEN_ID = cITIZEN_ID;
	}
	public String getCITIZEN_NAME() {
		return CITIZEN_NAME;
	}
	public void setCITIZEN_NAME(String cITIZEN_NAME) {
		CITIZEN_NAME = cITIZEN_NAME;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getPLAN_NAME() {
		return PLAN_NAME;
	}
	public void setPLAN_NAME(String pLAN_NAME) {
		PLAN_NAME = pLAN_NAME;
	}
	public String getPLAN_STATUS() {
		return PLAN_STATUS;
	}
	public void setPLAN_STATUS(String pLAN_STATUS) {
		PLAN_STATUS = pLAN_STATUS;
	}
	public LocalDate getPLAN_START_DATE() {
		return PLAN_START_DATE;
	}
	public void setPLAN_START_DATE(LocalDate pLAN_START_DATE) {
		PLAN_START_DATE = pLAN_START_DATE;
	}
	public LocalDate getPLAN_END_DATE() {
		return PLAN_END_DATE;
	}
	public void setPLAN_END_DATE(LocalDate pLAN_END_DATE) {
		PLAN_END_DATE = pLAN_END_DATE;
	}
	public Integer getBENEFIT_AMOUNT() {
		return BENEFIT_AMOUNT;
	}
	public void setBENEFIT_AMOUNT(Integer bENEFIT_AMOUNT) {
		BENEFIT_AMOUNT = bENEFIT_AMOUNT;
	}
	public String getDENIAL_REASON() {
		return DENIAL_REASON;
	}
	public void setDENIAL_REASON(String dENIAL_REASON) {
		DENIAL_REASON = dENIAL_REASON;
	}
	public LocalDate getTERMINATED_DATE() {
		return TERMINATED_DATE;
	}
	public void setTERMINATED_DATE(LocalDate tERMINATED_DATE) {
		TERMINATED_DATE = tERMINATED_DATE;
	}
	public String getTERMINATION_REASON() {
		return TERMINATION_REASON;
	}
	public void setTERMINATION_REASON(String tERMINATION_REASON) {
		TERMINATION_REASON = tERMINATION_REASON;
	}

}
