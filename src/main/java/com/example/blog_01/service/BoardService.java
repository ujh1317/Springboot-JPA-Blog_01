package com.example.blog_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_01.model.Board;
import com.example.blog_01.model.User;
import com.example.blog_01.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}//write()
	
	public Page<Board> boardList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}//boardList()
	
}//class
