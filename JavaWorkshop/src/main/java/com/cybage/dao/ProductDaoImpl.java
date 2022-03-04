package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.JDBCUtility.jdbcUtility;
import com.cybage.model.Product;

public class ProductDaoImpl implements ProductDao{

	private static Connection connection;
	private static PreparedStatement productDisplayAll,productInsert,productDelete,productGetById;
	
	static {
		connection=jdbcUtility.getConnection();
		try {
			productDisplayAll=connection.prepareStatement("select * from product");
			productInsert=connection.prepareStatement("Insert into product (name,price) values (?,?)");
			productDelete=connection.prepareStatement("delete from product where id=?");
			productGetById=connection.prepareStatement("select * from product where id=?");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int save(Product product) {
		try {
			productInsert.setString(1, product.getName());
			productInsert.setDouble(2, product.getPrice());
			int n=productInsert.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Product> display() {
		List<Product> list=new ArrayList<Product>();
		try {
			ResultSet resultSet=productDisplayAll.executeQuery();
			while(resultSet.next()) {
				list.add(new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3)));
				
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			productDelete.setInt(1, id);
			int a=productDelete.executeUpdate();
			if(a>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getById(int pid) {
		
		try {
			productGetById.setInt(1, pid);
			ResultSet rs=productGetById.executeQuery();
			if(rs.next()) {
				Product product=new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				return product;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	
}
