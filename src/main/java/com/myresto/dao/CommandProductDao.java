package com.myresto.dao;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Command;
import com.myresto.domaine.CommandProduct;
import com.myresto.domaine.Product;
import com.myresto.service.CommandService;
import com.myresto.service.ProductService;

@Repository
public class CommandProductDao implements ICommandProductDao {
@Autowired
private JdbcTemplate jdbcTemplate;
@Autowired
private CommandService commandeService;
	public CommandProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	//read
	/* @Override
	public List<CommandProduct> getAllCommandeProduit() {
		return jdbcTemplate.query("select * from myresto.commandeproduit", (resultSet, rowNum)->{
			CommandProduct cp = new CommandProduct(resultSet.getInt("id"),resultSet.getInt("idCommande"),resultSet.getInt("qte"),resultSet.getBoolean("menu"));
			Command cmd = commandeService.getCommandById(resultSet.getInt("idCommande"));
			System.out.println("this commande id:"+resultSet.getInt("idCommande"));
			List<Integer> produitsId=getProduitByCommandeId(resultSet.getInt("idCommande"));
			for(Integer i:produitsId) {
				System.out.println("id produit:"+i);
			}
			List<Product> produitsCommande=getAllProduitsByCommande(produitsId);
			int prixTotal=0;
			for(Product p:produitsCommande) {
				prixTotal+=p.getPrix();
			
			if(prixTotal>0 && resultSet.getBoolean("menu") ) {
				prixTotal=(int) (prixTotal-(0.5 *p.getPrix()));
			}
			}
			cp.setPrixTotal(prixTotal);
			cp.setProducts(productsCommand);
			cp.setCommands(cmd);
			
			return cp;
		});
	}
	
	//permet de retourner la liste des id des produits d'une commande
	@SuppressWarnings("deprecation")
	public List<Integer> getProduitByCommandeId(int id ) {
		Object[] arguments = new Object[1];
		arguments[0]= id;
		return  jdbcTemplate.query("select idProduit  from myresto.commandeproduit where idCommande =?",arguments, (resultSet, RowNum) ->{
			return resultSet.getInt("idProduit");
		});
	}
	//permet de retourner la liste des produits d'une commande
		@SuppressWarnings("deprecation")
		public List<Product> getAllProduitsByCommande(List<Integer> listId) {
			Object[] arguments = new Object[listId.size()];
			 String inSql = String.join(",", Collections.nCopies(listId.size(), "?"));
			for(int i=0;i<listId.size();i++) {
				arguments[i]= listId.get(i);
			}
			List<Product> produits = jdbcTemplate.query(
					String.format("SELECT * FROM myresto.produit WHERE id IN (%s)", inSql), 
					listId.toArray(), 
					 (rs, rowNum) -> new Product(rs.getInt("id"), rs.getInt("id_type"), rs.getString("libelle"),rs.getDouble("prix")));
			return produits;
			
		}
	//create
	@Override
	public void createCommandeProduit(CommandProduct cp) {
		for(int idProduit:cp.getIdProduit()) {
			Object[] arguments = new Object[4];
			arguments[0] = cp.getIdCommande();
			arguments[1] = idProduit;
			arguments[2] = cp.getQte();
			arguments[3] = cp.isMenu();
			jdbcTemplate.update("INSERT INTO myresto.commandeProduit(idCommande,idProduit,qte,menu) VALUES(?,?,?,?)",arguments);
		}
		
	}
	//update
	@Override
	public void updateCommandeProduit(CommandProduct cp) {
		for(int idProduit:cp.getIdProduit()) {
		Object[] arguments = new Object[5];
		arguments[0] = cp.getIdCommande();
		arguments[1] = idProduit;
		arguments[2] = cp.getQte();
		arguments[3] = cp.isMenu();
		arguments[4] = cp.getId();
		jdbcTemplate.update("UPDATE myresto.commandeproduit SET idCommande=?, idProduit=?,qte=?,menu=? WHERE id= ?",arguments[0],arguments[1],arguments[2], arguments[3],arguments[4]);
		}
	}
	//delete
	@Override
	public void deleteCommandeProduit(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.commandeProduit where commandeProduit.id="+id);
		
	} */
	@Override
	public List<CommandProduct> getAllCommandeProduit() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void createCommandeProduit(CommandProduct cp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateCommandeProduit(CommandProduct cp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCommandeProduit(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
