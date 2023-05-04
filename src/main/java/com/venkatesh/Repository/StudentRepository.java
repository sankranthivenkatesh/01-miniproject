package com.venkatesh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkatesh.entity.StudentEnquries;

public interface StudentRepository extends JpaRepository<StudentEnquries, Integer>{

}
