package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartItemDAO;
import com.niit.model.CartItem;

public class CartItemUnitTest {

	static CartItemDAO cartItemDAO;
	String errormsg = "Problem in insertion to CartItem";

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
	}

	@Test
	@Ignore
	public void addCartItemTest() {
		CartItem ci = new CartItem();
		// ci.setCartItemId(4);
		ci.setUsername("joshuaamaral52");
		ci.setPaymentStatus("np");
		ci.setProductId(1);
		ci.setQuantity(2);
		ci.setSubtotal(56381.0);
		ci.setOrderId(0);
		assertTrue(errormsg, cartItemDAO.addCartItem(ci));
	}

	@Test
	@Ignore
	public void getOneItemTest() {
		CartItem ci = cartItemDAO.getOneItem(2);
		System.out.println(ci);
		assertNotNull(errormsg, cartItemDAO.getOneItem(2));
	}

	@Test
	@Ignore
	public void getAllCartTest() {
		System.out.println("--All--");
		List<CartItem> cartlist = cartItemDAO.getAllCartItem("joshuaamaral52");
		for (CartItem cartItem : cartlist) {
			System.out.println(cartItem);
		}
		assertNotNull(errormsg, cartItemDAO.getAllCartItem("joshuaamaral52"));
	}

	@Test
	@Ignore
	public void getUnpaidItemsTest() {
		System.out.println("--Unpaid--");
		List<CartItem> cartlist = cartItemDAO.getAllUnpaidItem("joshuaamaral52");
		for (CartItem cartItem : cartlist) {
			System.out.println(cartItem);
		}
		assertNotNull(errormsg, cartItemDAO.getAllUnpaidItem("joshuaamaral52"));
	}

	@Test
	@Ignore
	public void getPaidItemsTest() {
		System.out.println("--Paid--");
		List<CartItem> cartlist = cartItemDAO.getAllPaidItem("joshuaamaral52");
		for (CartItem cartItem : cartlist) {
			System.out.println(cartItem);
		}
		assertNotNull(errormsg, cartItemDAO.getAllPaidItem("joshuaamaral52"));
	}

	@Test
	@Ignore
	public void deleteCartItem() {
		assertTrue(errormsg, cartItemDAO.deleteCartItem(4));
	}

	@Test
	@Ignore
	public void getByOIDTest() {
		List<CartItem> cartlist=cartItemDAO.getByOrderId(5);
		for (CartItem cartItem : cartlist) {
			System.out.println(cartItem);
		}
		assertNotNull(errormsg,cartItemDAO.getByOrderId(5));
	}
}
