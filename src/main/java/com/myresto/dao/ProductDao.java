package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Product;

@Repository
public class ProductDao implements IProductDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//READ
	public Product getProductById(int id) {
		return jdbcTemplate.queryForObject("Select * from myresto.product where product.id ="+id, (resultSet, rowNum) -> {
			return new Product(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("name"),resultSet.getDouble("price"));
		});
	}

	//Read
	public List<Product> getAllProducts(){
		return jdbcTemplate.query("Select * from myresto.product",(resultSet, rowNum) -> {
			return new Product(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("name"),resultSet.getDouble("price"));
		});
	}

	//CREATE
	public void createProduct(Product p) {
		Object[] arguments = new Object[3];
		arguments[0] = p.getIdType();
		arguments[1] = p.getName();
		arguments[2] = p.getPrice();
		jdbcTemplate.update("INSERT INTO myresto.product(id_type,name,price) VALUES(?,?,?)",arguments);
	}
	//UPDATE
	public void updateProduct(Product p) {
		Object[] arguments = new Object[3];
		arguments[0] = p.getIdType();
		arguments[1] = p.getName();
		arguments[2] = p.getPrice();
		jdbcTemplate.update("UPDATE myresto.product SET id_type=?,name=?,price=? where product.id="+p.getId(),arguments);
	}
	
	//DELETE
	public void deleteProduct(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.product where product.id="+id);
	}
}
