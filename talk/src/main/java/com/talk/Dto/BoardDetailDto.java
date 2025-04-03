package com.talk.Dto;

import java.time.LocalDate;
import java.util.List;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {
	private int id;
	private String title;
	private String memberId;
	private String content;
	private String fileName;
	private int hit;
	private LocalDate writerDate;
	private List<CommentViewDto> commentList;
	
	
	public static BoardDetailDto of(BoardEntity boardEntity,
			List<CommentViewDto> commentViewDtos) {
		BoardDetailDto boardDetailDto = new BoardDetailDto();
		
		boardDetailDto.setCommentList(commentViewDtos);
		boardDetailDto.setContent(boardEntity.getContent());
		boardDetailDto.setFileName(boardEntity.getFileName());
		boardDetailDto.setHit(boardEntity.getHit());
		boardDetailDto.setId(boardEntity.getId());
		boardDetailDto.setMemberId(boardEntity.getMemberId());
		boardDetailDto.setTitle(boardEntity.getTitle());
		boardDetailDto.setWriterDate(boardEntity.getWriteDate());
		
		return boardDetailDto;
	}
}