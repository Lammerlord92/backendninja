package com.udemy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.domain.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	//Primera forma
	//@GetMapping("/exampleString") hace lo mismo que la de abajo, se usa para no repetir
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model){
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	//Segunda forma
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV(){
		ModelAndView mav=new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people= new ArrayList<Person>();
		
		people.add(new Person("John", 23));
		people.add(new Person("Mike", 30));
		people.add(new Person("Eva", 40));
		people.add(new Person("Peter", 19));
		
		return people;
	}
}
