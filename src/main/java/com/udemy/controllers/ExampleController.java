package com.udemy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	//Primera forma
	//@GetMapping("/exampleString") hace lo mismo que la de abajo, se usa para no repetir
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model){
		model.addAttribute("name", "Jon");
		return EXAMPLE_VIEW;
	}
	//Segunda forma
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV(){
		ModelAndView mav=new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "Mike");
		return mav;
	}
}
