//package com.java.controller;
//
//import java.lang.ProcessBuilder.Redirect;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.java.dto.MemberDto;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import jakarta.websocket.Session;
//
//@Controller
//public class FController {
//	@Autowired HttpSession session;
//	
//	@GetMapping("/")
//	public String index() {
//		System.out.println("index 페이지가 열립니다.");		
//		return "index";
//	}
//	
//	@GetMapping("/meminfo") //회원정보
//	public String meminfo() {
//		return "meminfo";
//	}
//
//	@GetMapping("/member")
//	public String member() {
//		return "member";
//	}
//	
//	@PostMapping("/member")
//	public ModelAndView member(HttpServletRequest request,Model model) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String tel = request.getParameter("tel");
//		String gender = request.getParameter("gender");
//		String[] hobbys = request.getParameterValues("hobby");
//		String hobby ="";
//		
//		for(int i=0;i<hobbys.length;i++) {
//			if(i==0)
//				hobby+=hobbys[i];
//			else
//				hobby+=","+hobbys[i];
//		}
//		//model 사용
//		//model.addAttribute("member",new MemberDto(id,pw,name,tel,gender,hobby));
//		
//		//ModelAndView 사용
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("meminfo");
//		mv.addObject("member",new MemberDto(id,pw,name,tel,gender,hobby));
//		
//		return mv;
//	}
//	
//	
//	@GetMapping("/login")
//	public String login() {
//		System.out.println("login get방식");
//		return "login";
//	}
//	
//	@PostMapping("/login")
//	public String login(HttpServletRequest request, Model model) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		System.out.println("id: "+id);
//		System.out.println("pw: "+pw);
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		
//		session.setAttribute("id2", id);
//		
//		return "logininfo";
//	}
//	
//	@RequestMapping("/logout") // GetMapping, PostMapping 2개 모두 사용
//	public String logout() {
//		session.invalidate();
//		return "logout";
//	}
//	
//}
