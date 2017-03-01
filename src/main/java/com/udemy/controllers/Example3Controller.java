package com.udemy.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.domain.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static Log LOGGER=LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	//#1
//	@GetMapping("/")
//	public String redirect(){
//		return "redirect:/example3/showform";
//	}
	//#2
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public String showForm(Model model){
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson") //BindingResult=>Resultado que da spring al validar el formulario, según las anotaciones, requiere @Valid
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		//Si hay errores en el formulario (ver anotaciones del dominio)
		ModelAndView result=new ModelAndView();
		if(bindingResult.hasErrors()){
			result.setViewName(FORM_VIEW);
		}else{
			result.setViewName(RESULT_VIEW);
			result.addObject("person", person);
		}
		return result;
	}


}
