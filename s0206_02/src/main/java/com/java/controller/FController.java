package com.java.controller;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno: "+bno);
		System.out.println("btitle: "+btitle);
		
		model.addAttribute("bno", bno);
		model.addAttribute("btitle", btitle);
		return "index";
	}

	@PostMapping("/stuinput")
	public String stuinput(int stuno, String name,int kor,int math, int eng, Model model) {
		int total = kor+eng+math;
		double avg=total/3.0;
		
		model.addAttribute("stuno", stuno);
		model.addAttribute("name", name);
		model.addAttribute("kor", kor);
		model.addAttribute("math", math);
		model.addAttribute("eng", eng);
		model.addAttribute("total", total);
		model.addAttribute("avg", avg);
		return "dostuinput";
	}

	@GetMapping("/stuinput")
	public String stuinput() {
		
		return "stuinput";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, 
			@RequestParam ("id") String id, //form name="id" 데이터 입력받음
			@RequestParam (required = false) String pw,
			String name, //@requestparam 생략 가능, form이름과 같아야 함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0")int eng,
			int math, 
			Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
		
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		
//		int ikor=Integer.parseInt(akor);
//		int ieng=Integer.parseInt(aeng);
//		int imath=Integer.parseInt(amath);
//		int total = ikor+ieng+imath;
//		double aavg = total/3.0;
		
		System.out.println("데이터: "+id+","+pw);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("avg",avg);
		model.addAttribute("total",total);
		model.addAttribute("member",MemDto.builder().id(id).pw(pw).build());
		
		return "dologin";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
