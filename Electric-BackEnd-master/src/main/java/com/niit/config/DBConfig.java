package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.CartItemDAO;
import com.niit.DAO.CartItemDAOImpl;
import com.niit.DAO.CategoryDAO;
import com.niit.DAO.CategoryDAOImpl;
import com.niit.DAO.OrderDetailsDAO;
import com.niit.DAO.OrderDetailsDAOImpl;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.ProductDAOImpl;
import com.niit.DAO.SupplierDAO;
import com.niit.DAO.SupplierDAOImpl;
import com.niit.DAO.UserDAO;
import com.niit.DAO.UserDAOImpl;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetails;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/mobiledt");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		System.out.println("---Data Source Created---");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {

		Properties hibernateProp = new Properties();

		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addAnnotatedClass(CartItem.class);
		factoryBuilder.addAnnotatedClass(OrderDetails.class);
		factoryBuilder.addProperties(hibernateProp);

		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}

	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO() {
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}

	@Bean(name = "productDAO")
	public ProductDAO getProductDAO() {
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}

	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDAO() {
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDAOImpl();
	}

	@Bean(name = "userDAO")
	public UserDAO getUserDAO() {
		System.out.println("----User DAO Implementation---");
		return new UserDAOImpl();
	}

	@Bean(name = "cartItemDAO")
	public CartItemDAO getCartItemDAO() {
		System.out.println("----Cart Item DAO Implementation---");
		return new CartItemDAOImpl();
	}
	
	@Bean(name="orderDetailsDAO")
	public OrderDetailsDAO getOrderDetailsDAO(){
		System.out.println("----Order Details DAO Implementation----");
		return new OrderDetailsDAOImpl();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

}
