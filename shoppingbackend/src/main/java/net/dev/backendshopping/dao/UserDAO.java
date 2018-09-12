package net.dev.backendshopping.dao;

import java.util.List;

import net.dev.backendshopping.dto.User;

public interface UserDAO {

	User get(int id);	
	List<User> list();	
	boolean add(User user);	
	boolean update(User user);	
	boolean delete(User user);
	
}
