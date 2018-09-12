package net.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dev.backendshopping.dao.ProductDAO;
import net.dev.backendshopping.dto.Product;

public class ProductTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.dev.backendshopping");		
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}	
	
	/*
	@Test
	public void TestAddProduct()
	{
		product = new Product();
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Success!", true, productDAO.add(product));
		
	}*/	
	/*
	@Test
	public void TestUpdateProduct()
	{
		product = productDAO.get(6);
		
		product.setName("Oppo Selfie S53XX");
				
		assertEquals("Success!", true, productDAO.update(product));
		
	}*/
	/*
	@Test
	public void TestListProduct()
	{			
		assertEquals("Success!", 6, productDAO.list().size());
		
	}*/
	/*
	@Test
	public void TestDeleteProduct()
	{			
		product = productDAO.get(6);
		
		assertEquals("Success!", true, productDAO.delete(product));
		
	}*/
	
	/*@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());				
	} */
	
	
	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	/*@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} */
	
}
