package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier s) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(s);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Supplier getOneSupplier(int supId) {
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supId);
		return supplier;
	}

	public List<Supplier> getAllSupplier() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean deleteSupplier(int supId) {
		try {
			Supplier sup = getOneSupplier(supId);
			sessionFactory.getCurrentSession().delete(sup);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateSupplier(Supplier s) {
		try {
			int id=s.getSupplierId();
			Supplier sup=getOneSupplier(id);
			if (s.getSupplierName() != null)
				sup.setSupplierName(s.getSupplierName());
			if (s.getSupplierDesc()!= null)
				sup.setSupplierDesc(s.getSupplierDesc());
			sessionFactory.getCurrentSession().update(sup);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
