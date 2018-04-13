package com.niit.DAO;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
	public boolean addProduct(Product p);

	public Product getOneProduct(int prodid);

	public List<Product> getAllProduct();

	public boolean deleteProduct(int prodid);

	public boolean updateProduct(Product p);

}
