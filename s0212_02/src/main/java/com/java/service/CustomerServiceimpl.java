package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceimpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	int rowPerPage=10;
	@Override
	public ArrayList<BoardDto> notice() {
		ArrayList<BoardDto> list = customerMapper.selectAll();
		return list;
	}
	
	@Override
	public BoardDto nview(int bno) {
		BoardDto boardDto = customerMapper.selectOne(bno);
		return boardDto;
	}

	@Override
	public Map<String, Object> notice(int page, String category, String searchW) {
		int count = customerMapper.selectAll(category,searchW);
		
		int maxpage=(int)Math.ceil((double)count/rowPerPage);
		int startpage=(int)((page-1)/10)*10+1;
		int endpage = startpage+10-1;
		if(endpage>maxpage)endpage = maxpage;
		int startrow = (page-1)*10-1;
		int endrow = startrow+rowPerPage-1;
		
		ArrayList<BoardDto> notice = customerMapper.notice(startrow,endrow,category,searchW);
		Map<String,Object> map = new HashMap<>();
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("notice", notice);
		map.put("category", category);
		map.put("searchW", searchW);
		
		return map;
	}

}
