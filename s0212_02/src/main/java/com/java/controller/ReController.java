package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {
	@Autowired HttpSession session;
	@Autowired EventService eventService;
	
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno: "+cdto.getEno());
		System.out.println("cpw: "+cdto.getCpw());
		System.out.println("ccontent: "+cdto.getCcontent());
		cdto.setId("asd");
		
		//String id = session.getAttribute("session_id");
		//하단 댓글 저장
		CboardDto cboardDto = eventService.cwrite(cdto);
		return cboardDto; // 데이터 전달함, 페이지를 오픈하는것이 아님
	}
}
