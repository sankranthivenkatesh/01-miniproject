package com.ven.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ven.entity.Comments;

public interface commentsrepository extends JpaRepository<Comments, Integer>{

}
