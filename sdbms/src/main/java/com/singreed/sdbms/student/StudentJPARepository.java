package com.singreed.sdbms.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<Student, Integer>{
	public List<Student> findByName(String name);
	
}
