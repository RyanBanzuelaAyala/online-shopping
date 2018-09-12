package net.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dev.backendshopping.dao.UserDAO;
import net.dev.backendshopping.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.dev.backendshopping");
		context.refresh();

		userDAO = (UserDAO)context.getBean("userDAO");

	}
	
	/*@Test
	public void TestGetUser()
	{
		user = userDAO.get(1);
		
		assertEquals("Success", "Virat", user.getFirstName());
	}
	*/

	/*@Test
	public void TestAddUser() {
		
		user = new User();
		user.setFirstName("ryan");
		user.setLastName("ayala");
		user.setEmail("ryan@danubeco.com");
		user.setContactNumber("0564433271");
		user.setRole("Administrator");
		user.setPassword("12345678");
		user.setEnabled(true);

		assertEquals("Sucess!", true, userDAO.add(user));

	}*/
	
	@Test
	public void TestAddUser() {
		
		user = userDAO.get(5);

		assertEquals("Sucess!", true, userDAO.delete(user));

	}
}
