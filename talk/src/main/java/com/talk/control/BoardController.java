package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.talk.Dto.BoardDto;
import com.talk.Dto.CommentDto;
import com.talk.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 목록
	@GetMapping("/index")
	public String boardIndex(@RequestParam("page") int pageNum,	Model model) {
		return null;
	}
	//글 페이지
	@GetMapping("/write")
	public String  boardWrite(HttpSession session,	Model model) {
		return null;
	}
	//저장
	@GetMapping("/writeSave")
	public String  boardWrite(BoardDto boardDto,HttpSession session,
			Model model) {
		return null;
	}
	//삭제
	@GetMapping("/delete")
	public String  boardDelete(@RequestParam("id") int id ,	HttpSession session) {
		return null;
	}
	//수정 페이지
	@GetMapping("/updatePage")
	public String  boardUpdate(BoardDto boardDto,HttpSession session) {
		return null;
	}
	//수정
	@GetMapping("/update")
	public String  boardDetail(@RequestParam("id")	int id ,Model model) {
		return null;
	}
	//상세
	@GetMapping("/detail")
	public String  boardUpdate(@RequestParam("id")	int id,	HttpSession session , 
	Model model) {
		return null;
	}
	//댓글 저장
	@GetMapping("/commentSave")
	public String  commentSave(CommentDto commentDto ,HttpSession session) {
		return null;
	}
	//댓글 삭제
	@GetMapping("/commentDelete")
	public String  commentDel(@RequestParam("id") int id , HttpSession session) {
		return null;
	}
	
	
	
}
