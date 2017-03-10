package com.udemy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.domain.Course;
import com.udemy.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	//------------- Vistas --------------------
	private static final String COURSES_VIEW="courses";
	
	//------------- Servicios --------------------
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	//------------- Métodos Controlador --------------------
	@GetMapping("/listCourses")
	public ModelAndView listAllCourses(){
		ModelAndView res=new ModelAndView(COURSES_VIEW);
		res.addObject("courses", courseService.findAll());
		return res;
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course){
		courseService.saveCourse(course);
		return "redirect:/listCourses";
	}
}
