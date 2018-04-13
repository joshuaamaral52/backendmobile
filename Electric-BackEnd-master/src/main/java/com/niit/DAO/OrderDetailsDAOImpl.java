package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.OrderDetails;

@Repository("orderDetailsDAO")
@Transactional
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addOrder(OrderDetails od) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(od);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<OrderDetails> showAllPending() {
		Query query = sessionFactory.getCurrentSession().createQuery("from OrderDetails where deliveryStatus=?");
		query.setString(0, "Pending");
		return query.list();
	}

	public List<OrderDetails> showAllDispatched() {
		Query query = sessionFactory.getCurrentSession().createQuery("from OrderDetails where deliveryStatus=?");
		query.setString(0, "Dispatched");
		return query.list();
	}

	public OrderDetails getOrder(int orderId) {
		OrderDetails od = (OrderDetails) sessionFactory.getCurrentSession().get(OrderDetails.class, orderId);
		return od;
	}

	public List<OrderDetails> showAllSent(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from OrderDetails where deliveryStatus=? and username=?");
		query.setString(0, "Sent");
		query.setString(1, username);
		return query.list();
	}

	public List<OrderDetails> showAllSent() {
		Query query = sessionFactory.getCurrentSession().createQuery("from OrderDetails where deliveryStatus=?");
		query.setString(0, "Sent");
		return query.list();
	}

}
