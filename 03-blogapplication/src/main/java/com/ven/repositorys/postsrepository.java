package com.ven.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ven.entity.Post;

public interface postsrepository extends JpaRepository<Post, Integer>{

}
