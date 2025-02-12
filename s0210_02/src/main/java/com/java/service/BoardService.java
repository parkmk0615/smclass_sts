package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {
	//게시글 전체리스트
	Map<String, Object> blist(int page, String category, String searchW);

	void bwrite(BoardDto bdto);
	
	//1개 게시글 가져오기
	Map<String, Object> bview(int bno);
	
	//게시글 삭제
	void bdelete(int bno);

	//게시글 수정
	BoardDto bupdate(int bno);

	void bupdate(BoardDto bdto);
	
	//답변 달기
	BoardDto breply(int bno);

	//
	void breply(BoardDto bdto);


}
