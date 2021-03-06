package com.example.blog_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_01.config.auth.PrincipalDetail;
import com.example.blog_01.dto.ReplySaveRequestDto;
import com.example.blog_01.model.Board;
import com.example.blog_01.model.Reply;
import com.example.blog_01.model.User;
import com.example.blog_01.repository.BoardRepository;
import com.example.blog_01.repository.ReplyRepository;
import com.example.blog_01.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	@Transactional
	public void boardWrite(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}//write()
	
	@Transactional(readOnly = true)
	public Page<Board> boardList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}//boardList()
	
	@Transactional(readOnly = true)
	public Board boardDetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}//boardDetail()
	
	@Transactional
	public void boardUpdate(int id, Board requestBoard) {
			Board board = boardRepository.findById(id)
					.orElseThrow(()->{
						return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
					});
			board.setTitle(requestBoard.getTitle());
			board.setContent(requestBoard.getContent());
	}//boardUpdate()
	
	@Transactional
	public void boardDelete(int id, PrincipalDetail principal) {
		Board board = boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 찾기 실패 : 해당 게시글을 찾을 수 없습니다.");
		});
		if(board.getUser().getId() != principal.getUser().getId()) {
			throw new IllegalArgumentException("글 삭제 실패 : 해당 게시글을 삭제할 권한이 없습니다.");
		}
		boardRepository.delete(board);
	}//boardDelete()
	
	@Transactional
	public void replyWrite(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}//replyWrite()
	
	@Transactional
	public void replyDelete(int replyId) {
		replyRepository.deleteById(replyId);
	}//replyDelete()
	
}//class
