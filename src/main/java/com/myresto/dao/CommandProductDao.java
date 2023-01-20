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
private CommandService commandService;
	public CommandProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	//read
	@Override
	public List<CommandProduct> getAllCommandProduct() {
		return jdbcTemplate.query("select * from myresto.command_product", (resultSet, rowNum)->{
			CommandProduct cp = new CommandProduct(resultSet.getInt("id"),resultSet.getInt("id_command"),resultSet.getInt("qte"),resultSet.getBoolean("menu"));
			Command cmd = commandService.getCommandById(resultSet.getInt("id_command"));


			List<Integer> productsId=getProductByCommandId(resultSet.getInt("id_command"));
			List<Product> productsCommand=getAllProductsByCommand(productsId);
			double totalPrice=0;
			for(Product p:productsCommand) {
				totalPrice+=p.getPrice();
			
				if(totalPrice>0 && resultSet.getBoolean("menu") ) {
					totalPrice= totalPrice-(0.8 *p.getPrice());
				}
			}
			cp.setTotalPrice(totalPrice);
			cp.setProducts(productsCommand);
			cp.setCommands(cmd);
			
			return cp;
		});
	}
	
	//permet de retourner la liste des id des produits d'une commande
	@SuppressWarnings("deprecation")
	public List<Integer> getProductByCommandId(int id ) {
		Object[] arguments = new Object[1];
		arguments[0]= id;
		return  jdbcTemplate.query("select id_product  from myresto.command_product where id_command =?",arguments, (resultSet, rowNum) ->{
			return resultSet.getInt("id_product");
		});
	}
	//permet de retourner la liste des produits d'une commande
		@SuppressWarnings("deprecation")
		public List<Product> getAllProductsByCommand(List<Integer> listId) {
			Object[] arguments = new Object[listId.size()];
			 String inSql = String.join(",", Collections.nCopies(listId.size(), "?"));
			for(int i=0;i<listId.size();i++) {
				arguments[i]= listId.get(i);
			}
			List<Product> products = jdbcTemplate.query(
					String.format("SELECT * FROM myresto.product WHERE id IN (%s)", inSql), 
					listId.toArray(), 
					 (rs, rowNum) -> new Product(rs.getInt("id"), rs.getInt("id_type"), rs.getString("name"),rs.getDouble("price")));
			return products;
			
		}
	//create
	@Override
	public void createCommandProduct(CommandProduct cp) {
		System.out.println(cp);
			Object[] arguments = new Object[4];
			arguments[0] = cp.getIdCommand();
			arguments[1] = cp.getIdProduct();
			arguments[2] = cp.getQte();
			arguments[3] = cp.isMenu();
			jdbcTemplate.update("INSERT INTO myresto.command_product(id_command,id_product,qte,menu) VALUES(?,?,?,?)",arguments);
		
	}
	//update
	@Override
	public void updateCommandProduct(CommandProduct cp) {
		Object[] arguments = new Object[5];
		arguments[0] = cp.getIdCommand();
		arguments[1] = cp.getIdProduct();
		arguments[2] = cp.getQte();
		arguments[3] = cp.isMenu();
		arguments[4] = cp.getId();
		jdbcTemplate.update("UPDATE myresto.command_product SET id_command=?, id_product=?,qte=?,menu=? WHERE id= ?",arguments[0],arguments[1],arguments[2], arguments[3],arguments[4]);
	}
	//delete
	@Override
	public void deleteCommandProduct(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.command_product where command_product.id="+id);
		
	}

	
}
