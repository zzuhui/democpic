package com.weikehui.democpic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "首页");
		model.addAttribute("host", "localhost");
		return "index";
	}
	
	@RequestMapping("/index2")
	public String home2(Model model) {
		model.addAttribute("title", "首页");
		model.addAttribute("host", "localhost");
		return "index2";
	}

}
