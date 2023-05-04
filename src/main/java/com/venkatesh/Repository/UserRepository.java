package com.venkatesh.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.venkatesh.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	public UserDetails  findByEmail(String email);
	public UserDetails findByPwd(String pwd);
	


}
