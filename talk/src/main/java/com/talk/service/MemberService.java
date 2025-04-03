package com.talk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	//회원가입
	public void memberSave(MemberSignUpDto memberSignUpDto) {
		
	}
	// 로그인
	public boolean memberLogin(MemberSignInDto memberSignInDto) {
		return false;
	}
}