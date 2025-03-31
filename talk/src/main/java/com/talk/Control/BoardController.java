package com.talk.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talk.Service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	
}
