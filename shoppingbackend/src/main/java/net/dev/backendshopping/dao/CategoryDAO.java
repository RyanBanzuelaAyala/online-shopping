package net.dev.backendshopping.dao;

import java.util.List;

import net.dev.backendshopping.dto.Category;
import net.dev.backendshopping.dto.Product;

public interface CategoryDAO {
	
	Category get(int id);	
	List<Category> list();	
	boolean add(Category category);	
	boolean update(Category category);	
	boolean delete(Category category);
	
}
