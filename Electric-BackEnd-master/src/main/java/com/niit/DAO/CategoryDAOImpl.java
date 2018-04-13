package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category c) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(c);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Category getOneCategory(int catid) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, catid);
		return category;
	}

	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean deleteCategory(int id) {
		try {
			Category cat = getOneCategory(id);
			sessionFactory.getCurrentSession().delete(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateCategory(Category c) {
		try {
			int id = c.getCatid();
			Category cat = getOneCategory(id);
			if (c.getCatName() != null)
				cat.setCatName(c.getCatName());
			if (c.getCatDesc() != null)
				cat.setCatDesc(c.getCatDesc());
			sessionFactory.getCurrentSession().update(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
