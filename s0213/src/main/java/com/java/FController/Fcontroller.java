package com.java.FController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Fcontroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
