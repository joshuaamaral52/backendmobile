package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest {
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	@Ignore
	public void addSupplierTest() {
		Supplier supplier = new Supplier(1, "Joshua Amaral","Deals in Major Electronics");
		assertTrue("Problem to Supplier Insertion", supplierDAO.addSupplier(supplier));
	}

	@Test
	@Ignore
	public void getOneProductTest() {
		Supplier supplier = supplierDAO.getOneSupplier(1);
		System.out.println(supplier);
		assertNotNull("Error in getting Supplier", supplierDAO.getOneSupplier(1));
	}

	@Test
	@Ignore
	public void deleteProductTest() {
		assertTrue("Problem to delete Product", supplierDAO.deleteSupplier(2));
	}

	@Ignore
	@Test
	public void updateProductTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("Joshua Louis Amaral");
		assertTrue("Problem in update Product", supplierDAO.updateSupplier(supplier));
	}

	@Test
	@Ignore
	public void getallSupplierTest() {
		List<Supplier> supplist = supplierDAO.getAllSupplier();
		for (Supplier supplier : supplist) {
			System.out.println(supplier);
		}
		assertNotNull("Problem in getting all categories", supplierDAO.getAllSupplier());
	}
}
