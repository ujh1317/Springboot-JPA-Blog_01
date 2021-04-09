package com.example.blog_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_01.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}//interface
