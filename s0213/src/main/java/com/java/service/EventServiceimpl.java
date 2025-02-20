package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.EventDto;

@Service
public class EventServiceimpl implements EventService {
	@Autowired EventMapper eventMapper;
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}
	@Override
	public EventDto event(int eno) {
		EventDto list = eventMapper.selectone(eno);
		return list;
	}

}
