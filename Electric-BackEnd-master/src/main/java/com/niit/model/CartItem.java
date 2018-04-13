package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CartItem")
public class CartItem {

	@Id
	@GeneratedValue
	int cartItemId;
	int productId;
	int quantity;
	double subtotal;
	String username;
	int orderId;
	String paymentStatus;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", productId=" + productId + ", quantity=" + quantity
				+ ", subtotal=" + subtotal + ", username=" + username + ", orderId=" + orderId + ", paymentStatus="
				+ paymentStatus + "]";
	}

	public CartItem() {
	}

	public CartItem(int cartItemId, int productId, int quantity, double subtotal, String username, int orderId,
			String paymentStatus) {
		super();
		this.cartItemId = cartItemId;
		this.productId = productId;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.username = username;
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
	}
}
