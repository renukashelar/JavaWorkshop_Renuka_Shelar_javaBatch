package com.cybage.service;

import java.util.List;

import com.cybage.model.Product;

public interface ProductService {

	int addProduct();

	List<Product> displayAll();

	boolean deleteProduct();

	Product getById();

}
