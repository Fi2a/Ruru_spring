package com.talk.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.BoardEntity;

@Mapper
public interface BoardRepository {
	//게시글 저장 메서드
	public int insert(BoardEntity boardEntity);
	
	//게시글 상세보기
	public BoardEntity findById(int id);
	
	//게시글 삭제
	public int delete(int id);
	
	//게시글 수정
	public int update(BoardEntity boardEntity);
	
	//게시글 목록
	public List<BoardEntity> findByIdBetween(Map<String, Integer> map);
	
	//전체게시글 갯수
	public int findByAllCount();
	
	//최근글
	public List<BoardEntity> findByOrderByWriteDateDesc();
	
	//인기글
	public List<BoardEntity> findByOrderByHitDesc();
	
}