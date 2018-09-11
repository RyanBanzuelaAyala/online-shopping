package net.dev.backendshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.dev.backendshopping.dao.CategoryDAO;
import net.dev.backendshopping.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		//1
		Category category = new Category();
		
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("Latest Mobile");
		category.setImageURL("cat_1.jpg");
				
		categories.add(category);
		
		// 2
		category = new Category();
		
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("Latest Laptop");
		category.setImageURL("cat_2.jpg");
				
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		
		return categories;
		
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories)
		{
			if(category.getId() == id) return category;
		}
		
		return null;
		
	}
	
	

}
