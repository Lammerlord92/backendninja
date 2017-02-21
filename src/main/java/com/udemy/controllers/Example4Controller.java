package com.udemy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	public static final String VIEW = "example4";
	
	@GetMapping("/")
	public ModelAndView redirect(){
		return new ModelAndView(VIEW);
	}
}
