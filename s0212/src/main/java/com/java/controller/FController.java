package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class FController {
	
	@Autowired	BoardService boardService;
	
	@GetMapping("/board/bview") //게시글 1개 가져오기
	public String bview(int bno,Model model) {
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list= boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@ResponseBody //데이터를 전달해달라고요청
	@GetMapping("/rpage")
	public String rpage() {
		return "rpage";
	}
	@GetMapping("/")
	public String index() {
		return "index";
	}

//	@PostMapping("/board/bwrite") // 파일 여러개 업로드
//	public String bwrite(BoardDto bdto,List<MultipartFile> files) throws Exception{
//		
//		String real_fname ="";
//		
//		if(!files.isEmpty()) { //파일 첨부가 되어있으면
//			for(MultipartFile file : files) {
//				
//				//최초파일 이름 -> 중복 방지를 위해 파일 이름 변경
//				String origin_fname = file.getOriginalFilename();
//				System.out.println("최초파일이름: "+origin_fname);
//				long time = System.currentTimeMillis();
//				
//				//랜덤문자 생성 객체 UUID
//		UUID uuid = UUID.randomUUID();
//		String name= uuid+"_"+origin_fname;
//				
//				real_fname = String.format("%d_%s",time,origin_fname);
//				System.out.println("변경 파일 이름: "+real_fname);
//				// 파일 저장 위치
//				//String url = "C:/worksts/s0212/src/main/resources/static/upload/";
//				String url = "C:/upload/board/";
//				//파일 저장
//				File f = new File(url+real_fname);
//				
//				//파일 업로드
//				try {
//					file.transferTo(f);
//					//dto에 파일 이름 저장
//					bdto.setBfile(real_fname);
//				} catch (Exception e) {e.printStackTrace();} 
//				
//			}else {
//				bdto.setBfile("");
//			}
//		}
//			
//		boardService.bwrite(bdto);
//		
//		System.out.println("파일 업로드 성공!");
//		return "redirect:/board/blist";
//	}
	
	
	
	@PostMapping("/board/bwrite") // 파일 1개업로드
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile files) throws Exception{
		
		String real_fname ="";
		
		if(!files.isEmpty()) { //파일 첨부가 되어있으면
			//최초파일 이름 -> 중복 방지를 위해 파일 이름 변경
			String origin_fname = files.getOriginalFilename();
			System.out.println("최초파일이름: "+origin_fname);
			long time = System.currentTimeMillis();
			
			//랜덤문자 생성 객체 UUID
			UUID uuid = UUID.randomUUID();
			String name= uuid+"_"+origin_fname;
			
			real_fname = String.format("%d_%s",time,origin_fname);
			System.out.println("변경 파일 이름: "+real_fname);
			// 파일 저장 위치
			//String url = "C:/worksts/s0212/src/main/resources/static/upload/";
			String url = "C:/upload/board/";
			//파일 저장
			File f = new File(url+real_fname);
			
			//파일 업로드
			try {
				files.transferTo(f);
				//dto에 파일 이름 저장
				bdto.setBfile(real_fname);
			} catch (Exception e) {e.printStackTrace();} 
			
		}else {
			bdto.setBfile("");
		}
		boardService.bwrite(bdto);
		
		System.out.println("파일 업로드 성공!");
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
}
