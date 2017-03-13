package com.udemy.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.converters.CourseConverter;
import com.udemy.domain.Course;
import com.udemy.model.CourseModel;
import com.udemy.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	//------------- Vistas --------------------
	private static final String COURSES_VIEW="courses";
	private static final String EDIT_VIEW="courseEdit";
	//------------- Variables -----------------
	private static final Log LOG =LogFactory.getLog(CourseController.class);
	//------------- Convertidores --------------------
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	//------------- Servicios --------------------
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	//------------- Métodos Controlador --------------------
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/courses/listcourses");
	}
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call: listAllCourses()");
		ModelAndView res=new ModelAndView(COURSES_VIEW);
		//Para el formulario
		res.addObject("course", new CourseModel());
		res.addObject("courses", courseService.findAll());
		return res;
	}
	
	@GetMapping("/editcourse")
	public ModelAndView editCourse(int id){
		LOG.info("Call: editCourse()"+ "-- PARAM --> "+id);
		ModelAndView res=new ModelAndView(EDIT_VIEW);
		//Para el formulario
		res.addObject("course", courseService.getCourse(id));
		return res;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel){
		Course course=courseConverter.modelToEntity(courseModel);
		LOG.info("Call: addCourse() "+ "-- PARAM --> "+course.toString());
		courseService.saveCourse(course);
		return "redirect:listcourses";
	}
	
	@PostMapping("/editcourse")
	public String editCourse(@ModelAttribute("course") Course course){
		LOG.info("Call: addCourse() "+ "-- PARAM --> "+course.toString());
		courseService.saveCourse(course);
		return "redirect:listcourses";
	}
	
	@GetMapping("/delete")
	public String delete(int id){
		LOG.info("Call: deleteCourse() "+ "-- PARAM --> "+id);
		courseService.removeCourse(id);
		return "redirect:listcourses";
	}
}
