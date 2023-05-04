package com.venkatesh.formbinding;

import org.springframework.stereotype.Repository;

@Repository
public class DashBoardresponse {
	private Integer totalenq;
	private Integer enrolled;
	private Integer lost;
	public Integer getTotalenq() {
		return totalenq;
	}
	public void setTotalenq(Integer totalenq) {
		this.totalenq = totalenq;
	}
	public Integer getEnrolled() {
		return enrolled;
	}
	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}
	public Integer getLost() {
		return lost;
	}
	public void setLost(Integer lost) {
		this.lost = lost;
	}
	

}
