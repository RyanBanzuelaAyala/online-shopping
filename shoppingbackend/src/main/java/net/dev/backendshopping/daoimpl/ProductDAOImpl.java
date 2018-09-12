package net.dev.backendshopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dev.backendshopping.dao.ProductDAO;
import net.dev.backendshopping.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public Product get(int id) {
		try {
			return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Product> list() {

		return sessionfactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();

	}

	@Override
	public boolean add(Product product) {

		try {

			sessionfactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean update(Product product) {

		try {

			sessionfactory.getCurrentSession().update(product);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean delete(Product product) {

		try {

			sessionfactory.getCurrentSession().delete(product);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProduct = "FROM Product WHERE active = :active";

		return sessionfactory
				.getCurrentSession()
					.createQuery(selectActiveProduct, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int cartegoryid) {
		
		String selectActiveProductByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";

		return sessionfactory
				.getCurrentSession()
					.createQuery(selectActiveProductByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId", cartegoryid)
							.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionfactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
				
	}

}
