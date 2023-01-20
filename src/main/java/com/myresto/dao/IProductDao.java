package com.myresto.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import com.myresto.domaine.Product;

@Service
public interface IProductDao {
	List<Product> getAllProducts();
	void createProduct(Product p);
	Product getProductById( int id );
	void updateProduct(Product p);
	void deleteProduct(int id);
}
