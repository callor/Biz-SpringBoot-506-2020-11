package com.biz.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public String hello() {
		return "Hello Spring-boot Web Application";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("username","홍길동");
		model.addAttribute("tel","010-111-1111");
		return "home";
	}

}
