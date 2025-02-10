package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	// 게시글 전ㅊ ㅔ리스트
	ArrayList<BoardDto> blist();
	
	int insertBoard(BoardDto bdto);
	// 1개게시글 저장
	BoardDto selectOne(int bno);

	//조회수 +1 증가 - update
	void updateBhit(int bno);

	//게시글 삭제
	void deleteBoard(int bno);
	
}
