package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	
	@GetMapping("/")
	public String member(Model model) {
		ArrayList<MemberDto> list = memberService.member();
		model.addAttribute("list",list);
		return "index";
	}
}
