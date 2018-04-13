package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product p) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(p);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Product getOneProduct(int prodid) {
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, prodid);
		return product;
	}

	public List<Product> getAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean deleteProduct(int prodid) {
		try {
			Product prod = getOneProduct(prodid);
			sessionFactory.getCurrentSession().delete(prod);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateProduct(Product p) {
		try {
			int id = p.getProductId();
			Product prod = getOneProduct(id);
			if (p.getProdName() != null)
				prod.setProdName(p.getProdName());
			if (p.getPrice() < 0)
				prod.setPrice(p.getPrice());
			if (p.getproductDesc() != null)
				prod.setproductDesc(p.getproductDesc());
			if (p.getCatid() < 0)
				prod.setCatid(p.getCatid());
			if (p.getQuantity() < 0)
				prod.setQuantity(p.getQuantity());
			if (p.getSupplierid() < 0)
				prod.setQuantity(p.getSupplierid());
			sessionFactory.getCurrentSession().update(prod);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}