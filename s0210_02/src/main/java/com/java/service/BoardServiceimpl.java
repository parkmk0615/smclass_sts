package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceimpl implements BoardService {
	
	@Autowired BoardMapper boardMapper;

	@Override
	public ArrayList<BoardDto> blist() {
		
		ArrayList<BoardDto> blist = boardMapper.blist();
		return blist;
	}

	@Override
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("결과값: "+result);
		
	}

	@Override //1개 게시글 가져오기
	public BoardDto bview(int bno) {
		//조회수 +1 증가 - update
		boardMapper.updateBhit(bno);

		BoardDto boardDto = boardMapper.selectOne(bno);
		
		
		
		return boardDto;
	}

	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
		
		
	}
	

}
