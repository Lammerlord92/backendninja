package com.udemy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.services.EjercicioService;

@Controller
@RequestMapping("/ejercicio1")
public class EjercicioController {
	//------- Variables ----------
	private long tiempo;
	
	//------- Vistas ----------
	public static final String EJERCICIO_VIEW = "ejercicio";
	
	//------- Servicios ---------
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	//------- Métodos de controlador -------
	
	@GetMapping("/")
	public RedirectView metodoUno() {
		tiempo=System.currentTimeMillis();
		return new RedirectView("apartado1");

	}
	
	@GetMapping("/apartado1")
	public ModelAndView metodoDos() {
		ejercicioService.showLogInfo();
		ModelAndView mav=new ModelAndView(EJERCICIO_VIEW);
		long tiempoCarga=System.currentTimeMillis()-tiempo;
		String mensaje="Mensaje insertado en "+tiempoCarga+"ms";
		mav.addObject("mensaje",mensaje);
		return mav;
	}
	

}
