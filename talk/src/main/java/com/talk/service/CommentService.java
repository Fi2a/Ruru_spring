package com.talk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.Dto.CommentDto;
import com.talk.Entity.CommentEntity;
import com.talk.Repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	// 댓글 저장
	public void commentSave(CommentDto commentDto) {
		
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setBoardId( commentDto.getBoardId() );  
		commentEntity.setContent( commentDto.getContent() );  
		commentEntity.setMemberId( commentDto.getMemberId() );
		
		commentRepository.insert(commentEntity);
		
	}
	//댓글 삭제
	public void commentDelete(int id) {
		
	}
}