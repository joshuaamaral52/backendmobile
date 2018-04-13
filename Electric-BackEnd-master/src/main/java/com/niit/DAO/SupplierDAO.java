package com.niit.DAO;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier s);

	public Supplier getOneSupplier(int supId);

	public List<Supplier> getAllSupplier();

	public boolean deleteSupplier(int supId);

	public boolean updateSupplier(Supplier s);
}
