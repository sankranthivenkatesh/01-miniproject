package com.ven.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="comments_tbl")
public class Comments {
	
	@Id
	@GeneratedValue
	private Integer cid;
	
	private String name;
	
	private String email;
	
	private String content;
	
	@CreationTimestamp
	private LocalDate createddate;
	
	
	@ManyToOne
	@JoinColumn(name="postid")
	private Post post;

}
