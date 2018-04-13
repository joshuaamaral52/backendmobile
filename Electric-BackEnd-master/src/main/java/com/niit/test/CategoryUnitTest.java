package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryUnitTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		//when called will go to dbconfig & there specified to go to categoryDaoimpl
	}

	@Ignore
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCatid(1);
		category.setCatName("AC");
		category.setCatDesc("Keeps room cool");
		assertTrue("Problem to Category Insertion", categoryDAO.addCategory(category));
	}

	@Ignore
	@Test
	public void updateCategoryTest() {
		Category category = new Category();
		category.setCatid(1);
		category.setCatName("Refrigerator");
		category.setCatDesc("Keeps food cold");
		assertTrue("Problem in update Category", categoryDAO.updateCategory(category));
	}

	@Ignore
	@Test
	public void getOneCatTest() {
		Category cat = categoryDAO.getOneCategory(2);
		System.out.println(cat);
		assertNotNull("Error in getting Category", categoryDAO.getOneCategory(2));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		assertTrue("Problem to delete Category", categoryDAO.deleteCategory(3));
	}
	@Ignore
	@Test
	public void getAllCateogryTest()
	{
		List<Category> catlist=categoryDAO.getAllCategory();
		for (Category category : catlist) {
			System.out.println(category);
		}
		assertNotNull("Problem in getting all categories", categoryDAO.getAllCategory());
	}
}
