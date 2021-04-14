package com.example.blog_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog_01.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model) {
		model.addAttribute("boards", boardService.boardList());
		return "index";
	}//index()
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}//saveForm()
	
}//class
