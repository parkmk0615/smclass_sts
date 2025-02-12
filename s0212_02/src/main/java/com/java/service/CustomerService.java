package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface CustomerService {

	ArrayList<BoardDto> notice();

	BoardDto nview(int bno);

	Map<String, Object> notice(int page, String category, String searchW);

}
