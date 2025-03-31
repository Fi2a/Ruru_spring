package com.talk.Entity;

import com.talk.Dto.MemberSignUpDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEntity {
	
	private int id;
	private String memberId;
	private String password;
	private String name;
	private String email;
	private String tel;
	
	public static MemberEntity from(MemberSignUpDto memberSignUpDto) {
		MemberEntity memberEntity = new MemberEntity();
		
		
		
		return memberEntity;
	}

}
