package net.dev.backendshopping.dao;

import java.util.List;

import net.dev.backendshopping.dto.Product;


public interface ProductDAO {
	
	Product get(int id);	
	List<Product> list();	
	boolean add(Product product);	
	boolean update(Product product);	
	boolean delete(Product product);
	
	// business method
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int cartegoryid);
	List<Product> getLatestActiveProducts(int count);

}
