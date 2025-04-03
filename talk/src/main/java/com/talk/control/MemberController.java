package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.service.BoardService;
import com.talk.service.MemberService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final BoardService boardService;

	@Autowired
	private MemberService memberService;

    MemberController(BoardService boardService) {
        this.boardService = boardService;
    }
	
	@PostMapping("/signUp")
	public String signUp(@Valid MemberSignUpDto memberSignUpDto, BindingResult bindingResult ,Model model) {
		
		if( bindingResult.hasErrors() ) { // Valid 가 유효값 체크하여 유효하지않은 경우 에러가 발생한다.
			System.out.println("유효하지 않은 값이 입력 되었습니다.");
			return "index";
		}
		
		System.out.println( memberSignUpDto.getName() );
		return null;
	}
	
	@PostMapping("/signIn")
	public String signIn(MemberSignInDto memberSignInDto, Model model) {
		return null;
	}
}