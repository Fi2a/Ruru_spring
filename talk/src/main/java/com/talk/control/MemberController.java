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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/signUp")
	public String signUp(@Valid MemberSignUpDto memberSignUpDto, 
			BindingResult bindingResult ,Model model) {
		if( bindingResult.hasErrors() ) { // Valid 가  유효값 체크하여  유효하지않은 경우 에러가 발생한다.

			//최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent() );
			//인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPopular());
			
			model.addAttribute("memberSignInDto" , new MemberSignInDto() );
			model.addAttribute("open",1);
			return "index";
		}
		
		// 회원가입을 위해 입력한 값들이 올바른 값이라면 여기서부터 동작, 위에 if 는 올바르지 않을 경우
		
		memberService.memberSave(memberSignUpDto);
		
		return "redirect:/";
	}
	
	@PostMapping("/signIn")
	public String signIn(@Valid MemberSignInDto memberSignInDto, BindingResult bindingResult, Model model,
			 HttpSession session) {
		
		boolean hasError = bindingResult.hasErrors();
		if( !hasError ) {
			hasError = memberService.memberLogin(memberSignInDto); // true 면 틀렸다.
			
			if( hasError ) {
				bindingResult.reject("fail", "아이디 또는 비밀번호를 잘못 입력했습니다.");
				
				
			}
			
		}
		
		
		if( hasError ) { // 로그인 아이디 또는 비밀번호 입력안하거나 길이가 맞지않거나 영어 숫자 아닌경우
			
			//최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent() );
			//인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPopular());
			
			model.addAttribute("memberSignUpDto" , new MemberSignUpDto() );
			model.addAttribute("show",1);
			
			return "index";
		}
		
		// 아이디 비밀번호가 잘 입력된 후 실행되는 코드
		
		session.setAttribute("user", memberSignInDto.getMemberId() );
		
		
		
		return "redirect:/";
	}
}