package com.cybage.dao;

import java.util.List;

import com.cybage.model.Product;

public interface ProductDao {

	int save(Product product);

	List<Product> display();

	boolean deleteProduct(int id);

	Product getById(int pid);

}
