package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.OrderDetailsDAO;
import com.niit.model.OrderDetails;

public class OrderDetailsUnitTest {
	static OrderDetailsDAO orderDetailsDAO;
	String msg = "Problem in Order Details";

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		orderDetailsDAO = (OrderDetailsDAO) context.getBean("orderDetailsDAO");
	}

	@Test
	@Ignore
	public void addOrderTest() {
		OrderDetails od = new OrderDetails();
		od.setDeliveryStatus("pending");
		od.setOrderDate(new Date());
		od.setShippingAddress("addr");
		od.setTotalAmount(1000);
		od.setTransactionType("cod");
		od.setUsername("testuser");
		assertTrue(msg, orderDetailsDAO.addOrder(od));
		System.out.println(od.getOrderId());
	}

	@Test
	@Ignore
	public void getAllPendingTest() {
		List<OrderDetails> odlist = orderDetailsDAO.showAllPending();
		for (OrderDetails orderDetails : odlist) {
			System.out.println(orderDetails);
		}
		assertNotNull(msg, orderDetailsDAO.showAllPending());
	}

	@Test
	@Ignore
	public void getAllDispatchedTest() {
		List<OrderDetails> odlist = orderDetailsDAO.showAllDispatched();
		for (OrderDetails orderDetails : odlist) {
			System.out.println(orderDetails);
		}
		assertNotNull(msg, orderDetailsDAO.showAllDispatched());
	}
	
	@Test
	@Ignore
	public void getAllByUser(){
		List<OrderDetails> odlist=orderDetailsDAO.showAllSent("joshuaamaral52");
		for (OrderDetails orderDetails : odlist)
			System.out.println(orderDetails);
		assertNotNull(msg, orderDetailsDAO.showAllSent("joshuaamaral52"));
	}
	
	@Test
	@Ignore
	public void getOrder() {
		OrderDetails od = orderDetailsDAO.getOrder(1);
		System.out.println(od);
		assertNotNull(msg, orderDetailsDAO.getOrder(1));
	}
}
