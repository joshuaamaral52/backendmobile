package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierDesc="
				+ supplierDesc + "]";
	}

	@Id
	@GeneratedValue
	int supplierId;
	@Column
	String supplierName;
	@Column
	String supplierDesc;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierDesc() {
		return supplierDesc;
	}

	public void setSupplierDesc(String supplierDesc) {
		this.supplierDesc = supplierDesc;
	}

	public Supplier(int supplierId, String supplierName, String supplierDesc) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierDesc = supplierDesc;
	}

	public Supplier() {
		super();
	}

}
