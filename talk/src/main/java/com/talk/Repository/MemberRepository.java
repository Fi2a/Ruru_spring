package com.talk.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.MemberEntity;

@Mapper
public interface MemberRepository {
	// 회원가입
	public int insert(MemberEntity memberEntity);
	
	//로그인
	public boolean findByMemberIdAndPassword(MemberEntity memberEntity);
}