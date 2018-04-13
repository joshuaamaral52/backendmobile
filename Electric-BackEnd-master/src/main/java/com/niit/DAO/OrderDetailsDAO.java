package com.niit.DAO;

import java.util.List;

import com.niit.model.OrderDetails;

public interface OrderDetailsDAO {
	public boolean addOrder(OrderDetails od); 
	public List<OrderDetails> showAllPending();
	public List<OrderDetails> showAllDispatched();
	public List<OrderDetails> showAllSent();
	public List<OrderDetails> showAllSent(String username);
	public OrderDetails getOrder(int orderId);
}
