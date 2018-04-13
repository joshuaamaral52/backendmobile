package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserUnitTest {

	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	@Test
	@Ignore
	public void addUserTest() {
		User user=new User("joshuaamaral52", "Joshua Amaral", "joshuamaral52@gmail.com", "9867616596", "123456", "Malad, Mumbai - 400095", true, "User");
		assertTrue("Problem in User Assertion", userDAO.addUser(user));
	}

}
