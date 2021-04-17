package com.example.blog_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_01.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	
}//interface
