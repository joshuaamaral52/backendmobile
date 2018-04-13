package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

public class ProductUnitTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	//@Ignore
	public void addProductTest() {
		Product product = new Product(1, "Lenovo IdeaPad 110", "AMD A8-7410/8GB/1TB/DOS/2GB Graphics", 28190.50, 1, 20,1);
		assertTrue("Problem to Product Insertion", productDAO.addProduct(product));
	}

	@Test
	@Ignore
	public void getOneProductTest() {
		Product prod = productDAO.getOneProduct(1);
		System.out.println(prod);
		assertNotNull("Error in getting Category", productDAO.getOneProduct(1));
	}

	@Test
	@Ignore
	public void deleteProductTest() {
		assertTrue("Problem to delete Product", productDAO.deleteProduct(2));
	}

	@Ignore
	@Test
	public void updateProductTest() {
		Product product = new Product();
		product.setProductId(1);
		product.setproductDesc("AMD A8-7410/8GB RAM/1TB HDD/DOS/2GB Graphics");
		assertTrue("Problem in update Category", productDAO.updateProduct(product));
	}

	@Test
	@Ignore
	public void getallProductTest() {
		List<Product> prodlist = productDAO.getAllProduct();
		for (Product product:prodlist) {
			System.out.println(product);
		}
		assertNotNull("Problem in getting all categories", productDAO.getAllProduct());
	}
}
