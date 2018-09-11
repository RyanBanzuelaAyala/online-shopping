package net.dev.backendshopping.dao;

import java.util.List;

import net.dev.backendshopping.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);

}
