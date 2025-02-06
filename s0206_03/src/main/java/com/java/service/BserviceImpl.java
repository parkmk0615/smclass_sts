package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.StuDto;

@Service
public class BserviceImpl implements Bservice {

	@Override
	public String slist() {
		ArrayList<StuDto> list = new ArrayList<>();
		return "stu여러개보냄2";
	}
}
