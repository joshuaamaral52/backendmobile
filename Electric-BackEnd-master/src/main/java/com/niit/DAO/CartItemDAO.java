package com.niit.DAO;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDAO {
	public boolean addCartItem(CartItem ci);

	public boolean deleteCartItem(int cartItemId);

	public List<CartItem> getAllCartItem(String username);

	public CartItem getOneItem(int cartItemId);

	public List<CartItem> getAllUnpaidItem(String username);

	public List<CartItem> getAllPaidItem(String username);

	public List<CartItem> getByOrderId(int orderId);
}
