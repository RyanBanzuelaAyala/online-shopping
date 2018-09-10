package net.dev.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index" })
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Hello to MVC Ryan");
		
		return mv;
		
	}
	
	{
		
	// /test?greeting=hi
	
	//	@RequestMapping(value = "/test")
	//	// public ModelAndView test(@RequestParam("greeting")String greeting) { // this if required
	//	public ModelAndView test(@RequestParam(value = "greeting", required = false)String greeting) {
	//		
	//		if(greeting == null) {
	//			greeting = "Hi there!";
	//		}
	//		
	//		ModelAndView mv = new ModelAndView("page");
	//		mv.addObject("greeting", greeting);
	//		
	//		return mv;
	//		
	//	}
	
	// Clean URL PATH /test/hi
	
	//	@RequestMapping(value = "/test/{greeting}")
	//	public ModelAndView test(@PathVariable("greeting")String greeting) {	
	//		
	//		if(greeting == null) {
	//			greeting = "Hi there!";
	//		}
	//		
	//		ModelAndView mv = new ModelAndView("page");
	//		mv.addObject("greeting", greeting);
	//		
	//		return mv;
	//		
	//	}
		
		
	}
}
