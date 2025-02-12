package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional
@Service
public class BoardServiceimpl implements BoardService {
	
	@Autowired BoardMapper boardMapper;
	int rowPerPage = 10; //한 페이지 당 게시글 수
	
	@Override
	public Map<String, Object> blist(int page,String category, String searchW) {
		int count = boardMapper.countAll(category,searchW);
		
		int maxpage = (int)Math.ceil((double)count/rowPerPage);
		//첫번째 페이지
		int startpage = (int)((page-1)/10)*10+1;
		// 마지막 페이지
		int endpage = startpage+10-1;
		if(endpage>maxpage)endpage = maxpage;
		//요청 페이지 별 검색 번호
		int startrow = (page-1)*10+1;
		int endrow = startrow+rowPerPage-1;
		
		ArrayList<BoardDto> blist = boardMapper.blist(startrow,endrow,category,searchW);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("blist", blist);
		map.put("category", category);
		map.put("searchW", searchW);
		
		return map;
	}

	@Override
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("결과값: "+result);
		
	}

	@Override //1개 게시글 가져오기
	public Map<String, Object> bview(int bno) {
		Map<String, Object> map = new HashMap<>();
		//조회수 +1 증가 - update
		boardMapper.updateBhit(bno);
		// 현재 게시글 정보
		BoardDto boardDto = boardMapper.selectOne(bno);
		// 이전 게시글 정보
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		// 다음 게시글 정보
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		//System.out.println("prevDto: "+prevDto.getBno());
		return map;
	}

	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
		
		
	}

	@Override //게시글 수정
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
		
	}

	@Override
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override //답변 달기 저장
	public void breply(BoardDto bdto) {
		//같은 그룹에서 부모보다 bstep이 높은 게시글을 모두 +1 증가
		boardMapper.bstepUp(bdto);
		
		boardMapper.InsertBreply(bdto);
		
	}

}
