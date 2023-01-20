package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.IProductDao;
import com.myresto.domaine.Product;

@Service("ProduitService")
public class ProductService {
	
	@Autowired
	private IProductDao iProduitDao;
	
	public ProductService() {
	}

	public ProductService(IProductDao iProduitDao) {
		super();
		this.iProduitDao = iProduitDao;
	}
	
	public List<Product> getAllProducts(){
		return iProduitDao.getAllProducts();
	}

	public Product getProductById(int id){
		return iProduitDao.getProductById(id);
	}
	
	public void createProduct(Product p) {
		iProduitDao.createProduct(p);
	}
	public void updateProduct(Product p) {
		iProduitDao.updateProduct(p);
	}
	public void deleteProduct(int id) {
		iProduitDao.deleteProduct(id);
	}
	

}
