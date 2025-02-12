package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	
	@GetMapping("/customer/nview")
	public String nview(int bno,Model model) {
		BoardDto boardDto = customerService.nview(bno);
		model.addAttribute("bdto",boardDto);
		return"customer/nview";
	}
	
	@GetMapping("/customer/notice")
	public String notice(Model model, @RequestParam(value="page",defaultValue = "1")int page,
		String category, String searchW) {
		//현재날짜
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		System.out.println("현재날짜: "+today);
//		
//		ArrayList<BoardDto> list = customerService.notice();
//		model.addAttribute("list",list);
//		model.addAttribute("today",today);
		
		Map<String, Object> map = customerService.notice(page,category,searchW);
		model.addAttribute("page",map.get("page"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("category",map.get("category"));
		model.addAttribute("searchW",map.get("searchW"));
		
		return"notice";
	}
}
