package net.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dev.backendshopping.dao.CategoryDAO;
import net.dev.backendshopping.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.dev.backendshopping");		
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}	
	
	
	/*@Test
	public void testAddCategory()
	{
		category = new Category();
				
		category.setName("TV");
		category.setDescription("Latest TV");
		category.setImageURL("cat_3.jpg");
				
		assertEquals("Success!", true, categoryDAO.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		assertEquals("Success fetch single category", "TV", category.getName());
		
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("iTV");;
		
		assertEquals("Success fetch single category", true, categoryDAO.update(category));
		
	}*/

	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);
			
		assertEquals("Success fetch single category", true, categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testListCategory() {
					
		assertEquals("Success fetch single category", 2, categoryDAO.list().size());
		
	}*/
	
	
	@Test
	public void testCRUDCategory() {
		
		// ADD
		category = new Category();
		
		category.setName("Television");
		category.setDescription("Latest Television");
		category.setImageURL("cat_4.jpg");
				
		assertEquals("Success!", true, categoryDAO.add(category));
		
		// UPDATE
		category = categoryDAO.get(5);
		
		category.setName("TV");;
		
		assertEquals("Success fetch single category", true, categoryDAO.update(category));
		
		// LIST
		
		assertEquals("Success fetch single category", 3, categoryDAO.list().size());
		
		// DELETE
		category = categoryDAO.get(5);
		
		assertEquals("Success fetch single category", true, categoryDAO.delete(category));
		
		
	}

}
