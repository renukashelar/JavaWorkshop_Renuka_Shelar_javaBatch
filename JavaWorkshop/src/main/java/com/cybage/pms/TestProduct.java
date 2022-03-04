package com.cybage.pms;

import java.util.List;
import java.util.Scanner;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

public class TestProduct {

	public static void main(String[] args) {
		ProductService productService=new ProductServiceImpl();
		
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("\n1.Add Product \n2.Display Product details \n3.Delete Product by id  \n4.Get Product By id\n5. Exit");
			choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				 int n=productService.addProduct();
				 if(n>0) {
					 System.out.println("Insertion Done");
				 }else {
					 System.out.println("Insertion Fail");
				 }
				break;
			case 2:
				List<Product> plist=productService.displayAll();
				if(plist.isEmpty()) {
					System.out.println("List is Empty");
				}else {
					plist.forEach(System.out::println);
				}
				
				break;
			case 3:
				boolean result=productService.deleteProduct();
				if(result) {
					System.out.println("Product Deleted Successfully...");
				}else {
					System.out.println("Product Not Deleted");
				}
				break;
				
			case 4: 
				Product product=productService.getById();
				if(product !=null) {
					System.out.println(product);
				}else {
					System.out.println("Product is not available.....");
				}
				break;

			case 5:System.out.println("Thank You For Visiting........");
				//productService.closeConnection();
				System.exit(0);
				break;
	
			default:System.out.println("Wrong Choice");
				break;
			
			}
			
		}while(choice !=5);

	}

}
