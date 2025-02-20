package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.EventDto;


public interface EventService {

	ArrayList<EventDto> event();

	EventDto event(int eno);

}
