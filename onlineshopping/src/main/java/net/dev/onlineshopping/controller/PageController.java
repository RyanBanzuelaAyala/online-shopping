package net.dev.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dev.backendshopping.dao.CategoryDAO;
import net.dev.backendshopping.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index" })
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		
		mv.addObject("categories", categoryDAO.list());
				
		mv.addObject("userClickAllProducts", true);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("page");
				
		Category category = null;
		
		category = categoryDAO.get(id);
				
		mv.addObject("title", category.getName());
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
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
