package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService boardService;
	
	@GetMapping("/board/breply") // 답변달기 페이지
	public String breply(int bno, int page, Model model) {
		System.out.println("bno:"+bno);
		//1개 게시글 가져오기
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("breply",boardDto);
		return "breply";
	}
	
	@PostMapping("/board/breply") // 답변달기 페이지
	public String breply(BoardDto bdto) {
		System.out.println("bno:"+bdto.getBno());
		//1개 게시글 가져오기
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bupdate") // 게시글 수정
	public String bupdate(int bno,  Model model) {
		System.out.println("bno:"+bno);
		//1개 게시글 가져오기
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bupdate",boardDto);
		return "bupdate";
	}
	
	@PostMapping("/board/bupdate") // 게시글 수정 저장
	public String bupdate(BoardDto bdto,int page, Model model) {
		System.out.println("bno:"+bdto.getBno());
		//1개 게시글 가져오기
		boardService.bupdate(bdto);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bdelete") // 게시글 삭제
	public String bdelete(int bno, Model model) {
		System.out.println("bno:"+bno);
		//1개 게시글 가져오기
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	
	@GetMapping("/board/bview") // 글 상세보기 페이지
	public String bview(@RequestParam(defaultValue="1") int bno, int page, Model model) {
		//1개 게시글 가져오기
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bview",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("page",page);
		return "bview";
	}
	
	@GetMapping("/board/bwrite") // 글쓰기 페이지
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/board/bwrite")//글쓰기 저장
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile files)
	throws Exception {
		bdto.setBfile("");
		if(!files.isEmpty()) {
			String origin = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String realFileName = String.format("%d_%S", time, origin) ;
			String url= "c:/upload/board/";
			File f = new File(url+realFileName);
			files.transferTo(f);
			bdto.setBfile(realFileName);
		}
	
	boardService.bwrite(bdto);
	return "redirect:/board/blist?chkBwrite=1";
	}

	
	
	//전체 리스트, 검색 포함
	@GetMapping("/board/blist")
	public String blist(@RequestParam(value = "page",defaultValue = "1")int page, String category, String searchW, Model model) {
		
		Map<String, Object> map = boardService.blist(page,category,searchW);
		model.addAttribute("list",map.get("blist"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("category",map.get("category"));
		model.addAttribute("searchW",map.get("searchW"));
		return "blist";
	}
	
}
