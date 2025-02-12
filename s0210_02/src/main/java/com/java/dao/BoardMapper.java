package com.java.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	// 게시글 전ㅊ ㅔ리스트
	ArrayList<BoardDto> blist(int startrow, int endrow, String category, String searchW);
	
	int insertBoard(BoardDto bdto);
	
	// 1개게시글 저장
	BoardDto selectOne(int bno);

	//조회수 +1 증가 - update
	void updateBhit(int bno);

	//게시글 삭제
	void deleteBoard(int bno);

	//게시글 수정
	void updateBoard(BoardDto bdto);
	
	// 답변 달기: 자식 게시글 bstep 1증가
	void bstepUp(BoardDto bdto);
	// 답변달기 저장
	void InsertBreply(BoardDto bdto);
	
	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);
	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);
	// 하단 넘버링 - 게시글 총 개수
	int countAll(String category, String searchW);
	

}
