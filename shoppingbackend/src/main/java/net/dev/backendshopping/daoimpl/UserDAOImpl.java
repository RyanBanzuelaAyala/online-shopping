package net.dev.backendshopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dev.backendshopping.dao.UserDAO;
import net.dev.backendshopping.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public User get(int id) {

		return sf.getCurrentSession().get(User.class, Integer.valueOf(id));
	}

	@Override
	public List<User> list() {

		return sf.getCurrentSession().createQuery("FROM User", User.class).getResultList();
	}

	@Override
	public boolean add(User user) {

		try {

			sf.getCurrentSession().persist(user);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean update(User user) {

		try {

			sf.getCurrentSession().update(user);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean delete(User user) {

		try {

			sf.getCurrentSession().delete(user);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;

		}
		
	}

}
