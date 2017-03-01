package com.udemy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.components.ExampleComponent;
import com.udemy.domain.Person;
import com.udemy.services.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	@Autowired
	@Qualifier("exampleComponent")	//Nombre del bean
	private ExampleComponent exampleComponent;
	@Autowired
	@Qualifier("exampleService")	//Nombre del bean
	private ExampleService exampleSevice; //LLamamos a la interfaz
	
	//Primera forma
	//@GetMapping("/exampleString") hace lo mismo que la de abajo, se usa para no repetir
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model){
		exampleComponent.sayHello();
		model.addAttribute("people", exampleSevice.getListPeople());
		return EXAMPLE_VIEW;
	}
	//Segunda forma
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV(){
		ModelAndView mav=new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleSevice.getListPeople());
		return mav;
	}
	
}
