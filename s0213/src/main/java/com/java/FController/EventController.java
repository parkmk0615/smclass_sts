package com.java.FController;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.EventDto;
import com.java.service.EventService;


@Controller
public class EventController {
	
	@Autowired EventService eventService;
	
	@GetMapping("/event/eview")
	public String eview(int eno) {
		EventDto eventdto = eventService.event(eno);
//		model.addAttribute("list",list);
		return "event/eview";
	}
	
	@GetMapping("/event/event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.event();
		model.addAttribute("list",list);
		return "event/event";
	}
}
