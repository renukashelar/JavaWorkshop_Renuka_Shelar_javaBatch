package com.cybage.service;

import java.util.List;
import java.util.Scanner;

import com.cybage.dao.ProductDao;
import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;

public class ProductServiceImpl implements ProductService{
	
	ProductDao productDao;
	Scanner sc=new Scanner(System.in);
	
	public ProductServiceImpl() {
		productDao= new ProductDaoImpl();
	}
	

	public int addProduct() {
		
		System.out.println("Enter Product Name");
		String name=sc.next();
		System.out.println("Eneter Product Price");
		double price=sc.nextDouble();
		
		Product product=new Product(name,price);
		return productDao.save(product);
	}

	@Override
	public List<Product> displayAll() {
		
		return productDao.display();
	}

	@Override
	public boolean deleteProduct() {
		System.out.println("Enter Product id");
		int id=sc.nextInt();
		return productDao.deleteProduct(id);
	}


	@Override
	public Product getById() {
		System.out.println("Enter Product id");
		int pid=sc.nextInt();
		
		return productDao.getById(pid);
	}

}
