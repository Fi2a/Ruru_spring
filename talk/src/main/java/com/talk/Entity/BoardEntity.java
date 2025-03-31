package com.talk.Entity;

import java.time.LocalDate;

import com.talk.Dto.BoardDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
	
	private int id;
	private String title;
	private int memberId;
	private String content;
	private String fileName;
	private int hit;
	private LocalDate writeDate;
	
	public static BoardEntity from(BoardDto boardDto) {
		BoardEntity boardEntity = new BoardEntity();
		
		
		
		
		return boardEntity;
	}
	
	
	
}
