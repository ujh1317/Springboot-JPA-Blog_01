package com.example.blog_01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.blog_01.model.Board;
import com.example.blog_01.model.User;

//DAO
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
}//interface
