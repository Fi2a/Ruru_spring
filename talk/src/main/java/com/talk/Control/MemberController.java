package com.talk.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talk.Service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

}
