package com.ven.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="post_tbl")
public class Post {
	
	@Id
	@GeneratedValue
	private Integer postid;
	private String tittle;
	
	private String description;
	
	@Lob
	private String content;
	
	@CreationTimestamp
	private LocalDate createddate;
	
	@UpdateTimestamp
	private LocalDate updatedate;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.REMOVE)
	private List<Comments> comments;
    
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
}
