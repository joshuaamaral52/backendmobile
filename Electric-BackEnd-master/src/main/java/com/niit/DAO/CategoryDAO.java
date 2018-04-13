package com.niit.DAO;

import java.util.List;
import com.niit.model.Category;

public interface CategoryDAO {
	public boolean addCategory(Category c);

	public Category getOneCategory(int catid);

	public List<Category> getAllCategory();

	public boolean deleteCategory(int id);

	public boolean updateCategory(Category c);
}
