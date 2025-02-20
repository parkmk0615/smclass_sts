package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceimpl implements BoardService {
	@Autowired BoardMapper boardMapper;
	
	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
	}

	@Override
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return null;
	}

}
