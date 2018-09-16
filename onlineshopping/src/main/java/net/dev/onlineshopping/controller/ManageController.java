package net.dev.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.dev.backendshopping.dao.CategoryDAO;
import net.dev.backendshopping.dao.ProductDAO;
import net.dev.backendshopping.dto.Category;
import net.dev.backendshopping.dto.Product;
import net.dev.onlineshopping.util.FileUploadUtility;
import net.dev.onlineshopping.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManageController {

	private static final Logger logger = LoggerFactory.getLogger(ManageController.class);
		
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManagementProducts(@RequestParam(name="operation", required=false)String operation) {
				
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);		
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Added!");
			}
		}
		
		return mv;
		
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product")Product mProduct, BindingResult result, Model model, HttpServletRequest request) {
				
		new ProductValidator().validate(mProduct, result);
		
		if(result.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickManageProduct",true);
			model.addAttribute("title", "Manage Products");
			return "page";
		}			
		
		logger.info(mProduct.toString());
		
		productDAO.add(mProduct);	
		
		//upload the file
		 if(!mProduct.getFile().getOriginalFilename().equals("") ){
			 FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode()); 
		 }
		 
		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {		
		
		Product product = productDAO.get(id);
		
		boolean isActive = product.isActive();
		
		product.setActive(!isActive);
		
		productDAO.update(product);
		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
		
	}
				
	@RequestMapping("/{id}/product")
	public ModelAndView manageProductEdit(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		// Product nProduct = new Product();		
		mv.addObject("product", productDAO.get(id));

			
		return mv;
		
	}
	
	@RequestMapping(value = "/product/{id}/delete", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductDelete(@PathVariable int id) {		
		
		Product product = productDAO.get(id);
		
		FileUploadUtility.deleteFile(product.getCode()); 
				
		productDAO.delete(product);
		
		return "Product deleted successfully!";
		
	}
					
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}
	
}
