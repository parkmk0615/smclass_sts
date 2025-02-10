package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	//MemberService memberService2 = new MemberServiceimpl();
	@Autowired HttpSession session;
	
	@GetMapping("/member/member") //회원가입페이지
	public String member() {
		return "member";
	}
	
	@PostMapping("/member/member") //회원가입저장
	public String member(MemberDto mdto) {
		System.out.println("입력된 name : "+mdto.getName());
		memberService.member(mdto);
		return "redirect:/";
	}
	
	@GetMapping("/member/login") //로그인 페이지
	public String login() {
		return "login";
	}
	
	@GetMapping("/member/logout") //로그아웃 페이지
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin","0");
		return "redirect:/?";
	}
	
	@PostMapping("/member/login")
	public String login(String id,String pw, Model model) {
		MemberDto memberDto = memberService.login(id,pw);
		if(memberDto != null) {
			model.addAttribute("chkLogin","1");		
			session.setAttribute("session_id",id);
			session.setAttribute("session_name",memberDto.getName());
		}else {
			model.addAttribute("chkLogin","0");			
		}
		return "login";
	}
}
