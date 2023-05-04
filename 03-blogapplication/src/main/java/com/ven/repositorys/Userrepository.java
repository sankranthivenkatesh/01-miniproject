package com.ven.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ven.entity.User;

public interface Userrepository extends JpaRepository<User, Integer>{

	public User  findByPwd(String pwd);
	
	public User findByEmail(String email);
}
