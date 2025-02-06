package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;
import com.java.service.Bservice;

import lombok.Getter;

@Controller
public class FController {
	@Autowired Bservice b;
	
	@GetMapping("/")
	public String index() {
		return"index";
	}
	
	@GetMapping("/data1")
	public String data1(@RequestParam(defaultValue = "1")int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data1";
	}
	
	@GetMapping("/data2/{bno}") //pathvariable 방식
	public String data2(@PathVariable int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data2";
	}

	@GetMapping("/data3/{bno}") //pathvariable 방식
	public String data3(@PathVariable List<Integer> bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data3";
	}
	@GetMapping("/data4")
	public String data4() {
		
		String str=b.slist();
		System.out.println("str: "+str);
		return "data4";
	}
	
	@GetMapping("/stuinput")
	public String stuinput() {
		return "stuinput";
	}

	@PostMapping("/stuinput")
	public String stuinput(StuDto sdto, Model model) {
		
		int total=sdto.getKor()+sdto.getEng()+sdto.getMath();
		double avg = total/3.0;
		
		model.addAttribute("total1",total);
		model.addAttribute("avg",avg);
		
		model.addAttribute("sdto",sdto);
		return "dostuinput";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/meminfo")
	public String meminfo(MemDto mdto,Model model) {
		System.out.println("mdto id: "+mdto.getId());
		System.out.println("mdto id: "+mdto.getHobby());
		model.addAttribute("member",mdto);
		return "meminfo";
	}
//	@PostMapping("/meminfo")
//	public String meminfo(String id, String pw, String name,
//			String tel, String gender, String[] hobby,Model model) {
//		System.out.println("id: "+id);
//		System.out.println("hobby: "+Arrays.toString(hobby));
//		String hobbys="";
//		for(int i=0; i<hobby.length;i++) {
//			if
//				(i==0) hobbys+=hobby[i];
//			else
//				hobbys +=","+hobby[i];
//		}
//		model.addAttribute("member",new MemDto(id,pw,name,tel,gender,hobbys));
//		
//		return "meminfo";
//	}
	
}
