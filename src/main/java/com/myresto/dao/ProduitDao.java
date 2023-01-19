package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Produit;

@Repository
public class ProduitDao implements IProduitDao{

	private JdbcTemplate jdbcTemplate;
	
	public ProduitDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//READ
	public Produit getProductById(int id) {
		return jdbcTemplate.queryForObject("Select * from myresto.produit where produit.id ="+id, (resultSet, rowNum) -> {
			return new Produit(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("libelle"),resultSet.getDouble("prix"));
		});
	}

	//Read
	public List<Produit> getAllProducts(){
		return jdbcTemplate.query("Select * from myresto.produit",(resultSet, rowNum) -> {
			return new Produit(resultSet.getInt("id"),resultSet.getInt("id"),resultSet.getString("libelle"),resultSet.getDouble("prix"));
		});
	}

	//CREATE
	public void createProduct(Produit p) {
		Object[] arguments = new Object[3];
		arguments[0] = p.getidType();
		arguments[1] = p.getLibelle();
		arguments[2] = p.getPrix();
		jdbcTemplate.update("INSERT INTO myresto.produit(id_type,libelle,prix) VALUES(?,?,?)",arguments);
	}
	//UPDATE
	public void updateProduct(Produit p) {
		Object[] arguments = new Object[3];
		arguments[0] = p.getidType();
		arguments[1] = p.getLibelle();
		arguments[2] = p.getPrix();
		jdbcTemplate.update("UPDATE myresto.produit SET id_type=?,libelle=?,prix=? where produit.id="+p.getId(),arguments);
	}
	
	//DELETE
	public void deleteProduct(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.produit where produit.id="+id);
	}
}
