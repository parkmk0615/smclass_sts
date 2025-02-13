package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Service
public class EventServcieimpl implements EventService {
	@Autowired EventMapper eventMapper;

	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.event();
		return list;
	}

	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventMapper.selectOne(eno);
		return eventDto;
	}

	@Override //하단 댓글 가져오기
	public ArrayList<CboardDto> clist(int eno) {
		ArrayList<CboardDto> clist = eventMapper.selectAllCboard(eno);
		return clist;
	}

	@Override
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("cwrite 저장 전 : "+cdto.getCno());
		eventMapper.insertCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		
		return cboardDto;
	}

}
