package net.dev.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManagementProducts() {
				
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userClickManageProduct", true);		
		mv.addObject("title", "Manage Products");
		
		return mv;
		
	}
	
	
	
	
}
