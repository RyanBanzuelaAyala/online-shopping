package net.dev.backendshopping.dao;

import java.util.List;

import net.dev.backendshopping.dto.Address;
import net.dev.backendshopping.dto.Cart;
import net.dev.backendshopping.dto.User;

public interface UserDAO {

	User get(int id);	
	
	List<User> list();	
			
	boolean update(User user);
	
	boolean delete(User user);
	
	boolean add(User user);	
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippinhAddress(User user);
	
	// alternate
	//Address getBillingAddress(int userId);
	//List<Address> listShippinhAddress(int userId);
	
	boolean updateCart(Cart cart);
	
}
