package com.dunkin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home(Model model) {
		String name="민윤지";
		int age=29;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "index";
	}

}
