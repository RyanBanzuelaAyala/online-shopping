package net.dev.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dev.backendshopping.dao.UserDAO;
import net.dev.backendshopping.dto.Address;
import net.dev.backendshopping.dto.Cart;
import net.dev.backendshopping.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user;
	private Address address;
	private Cart cart;

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
	
	/*@Test
	public void TestAddUser() {
		
		user = userDAO.get(5);

		assertEquals("Sucess!", true, userDAO.delete(user));

	}*/
	
	/*@Test
	public void TestAddAdd() {
				
		user = new User() ;
		user.setFirstName("Hrithik2");
		user.setLastName("Roshan2");
		user.setEmail("hr2@gmail.com");
		user.setContactNumber("12345123452");
		user.setRole("USER");
		user.setPassword("123456");
		user.setEnabled(true);
		
		assertEquals("Failed user!", true, userDAO.add(user));
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUserId(user.getId());

		assertEquals("Failed address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("Failed cart!", true, userDAO.addCart(cart));
						
			  address = new Address();
			  address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			  address.setAddressLineTwo("Near Kudrat Store");
			  address.setCity("Mumbai");
			  address.setState("Maharashtra");
			  address.setCountry("India");
			  address.setPostalCode("400001");
			  address.setShipping(true);
			  
			  address.setUserId(user.getId());
			  
			  assertEquals("Failed ship address!", true, userDAO.addAddress(address));
			
		}

	}*/
	
	/*@Test
	public void TestAdd() {
				
		user = new User() ;
		user.setFirstName("Hrithik2");
		user.setLastName("Roshan2");
		user.setEmail("hr2@gmail.com");
		user.setContactNumber("12345123452");
		user.setRole("USER");
		user.setPassword("123456");
		user.setEnabled(true);
		
		if(user.getRole().equals("USER")) {
			
			cart = new Cart();
			
			cart.setUser(user);
			
			user.setCart(cart);
						
		}
		
		assertEquals("Failed user!", true, userDAO.add(user));
				

	}*/
	
	/*@Test
	public void TestUpdateCart() {
				
		user = userDAO.getByEmail("hr2@gmail.com");
		
		cart = user.getCart();
		
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("Failed user!", true, userDAO.updateCart(cart));
				

	}*/
	
	/*@Test
	public void TestGetBilling() {
				
		user = new User() ;
		user.setFirstName("Hrithik2");
		user.setLastName("Roshan2");
		user.setEmail("hr2@gmail.com");
		user.setContactNumber("12345123452");
		user.setRole("USER");
		user.setPassword("123456");
		user.setEnabled(true);
		
		assertEquals("Failed user!", true, userDAO.add(user));
				
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUser(user);
				
		assertEquals("Failed add user!", true, userDAO.addAddress(address));
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		  
		address.setUser(user);
		  
		assertEquals("Failed ship address!", true, userDAO.addAddress(address));
		

	}*/
	
	/*@Test
	public void TestGetShipping() {
				
		user = userDAO.getByEmail("hr2@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("wqeq");
		address.setState("awdada");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		  
		address.setUser(user);
		  
		assertEquals("Failed ship address!", true, userDAO.addAddress(address));
		

	}*/
	
	
	@Test
	public void TestGetListAddresses() {
				
		user = userDAO.getByEmail("hr2@gmail.com");
				
		assertEquals("Failed ship address!", 2, userDAO.listShippinhAddress(user).size());
		
		assertEquals("Failed ship address!", "Mumbai", userDAO.getBillingAddress(user).getCity());
		

	}
}
