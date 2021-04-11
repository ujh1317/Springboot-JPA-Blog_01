package com.example.blog_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.blog_01.model.User;

//DAO
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//	@Query(value = "SELECT * FROM user WHERE username=? AND password=?", nativeQuery = true)
	//	User login(String username, String password);

	//JPA Naming 전략
	//SELECT * FROM user WHERE username=? AND password=?;
	//User findByUsernameAndPassword(String username, String password);
	
	
}//interface
