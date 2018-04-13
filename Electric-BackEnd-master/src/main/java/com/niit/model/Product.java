package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue
	int productId;
	@Column
	String prodName;
	@Column
	String productDesc;
	@Column
	double price;
	@Column
	int catid;
	@Transient
	MultipartFile image;
	@Column
	int quantity;
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Column
	int supplierid;

	public int getProductId() {
		return productId;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getproductDesc() {
		return productDesc;
	}

	public void setproductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product() {
	}

	public Product(int productId, String prodName, String productDesc, double price, int catid, int quantity,
			int supplierid) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.productDesc = productDesc;
		this.price = price;
		this.catid = catid;
		this.quantity = quantity;
		this.supplierid = supplierid;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", productDesc=" + productDesc + ", price="
				+ price + ", catid=" + catid + ", quantity=" + quantity + ", supplierid=" + supplierid + "]";
	}

	
}
