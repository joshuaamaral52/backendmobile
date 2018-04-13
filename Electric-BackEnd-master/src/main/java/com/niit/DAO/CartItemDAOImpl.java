package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCartItem(CartItem ci) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(ci);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean deleteCartItem(int cartItemId) {

		try {
			CartItem ci = getOneItem(cartItemId);
			sessionFactory.getCurrentSession().delete(ci);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<CartItem> getAllCartItem(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from CartItem where username=?");
		query.setString(0, username);
		return query.list();
	}

	public CartItem getOneItem(int cartItemId) {
		CartItem ci = (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, cartItemId);
		return ci;
	}

	public List<CartItem> getAllUnpaidItem(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from CartItem where paymentStatus=? and username=?");
		query.setString(0, "np");
		query.setString(1, username);
		return query.list();
	}

	public List<CartItem> getAllPaidItem(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from CartItem where paymentStatus=? and username=?");
		query.setString(0, "p");
		query.setString(1, username);
		return query.list();
	}

	public List<CartItem> getByOrderId(int orderId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from CartItem where orderId=?");
		query.setInteger(0, orderId);
		return query.list();
	}

}
