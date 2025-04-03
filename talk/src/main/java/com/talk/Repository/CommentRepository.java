package com.talk.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.CommentEntity;

@Mapper
public interface CommentRepository {
	
	// 댓글 저장
	public int insert(CommentEntity  commentEntity);
	
	//댓글 삭제
	public int delete(int id);
	
	//게시글 댓글 목록
	public List<CommentEntity> findByBoardIdOrderIdDesc(int id);
}