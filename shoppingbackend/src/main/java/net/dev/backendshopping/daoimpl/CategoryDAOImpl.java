package net.dev.backendshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dev.backendshopping.dao.CategoryDAO;
import net.dev.backendshopping.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private static SessionFactory sessionfactory;
	
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

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			
			sessionfactory.getCurrentSession().persist(category);
						
			return true;
			
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	

}
