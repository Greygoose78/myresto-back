package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresto.domaine.Commande;

@Repository
public class CommandeDao implements ICommandeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CommandeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	//READ
	@SuppressWarnings("deprecation")
	@Override
	public Commande getCommandeById(int id ) {
		Object[] arguments = new Object[1];
		arguments[0]= id;
		return (Commande) jdbcTemplate.queryForObject("Select * from commande where id=?",arguments, (resultSet, RowNum) ->{
			return new Commande(resultSet.getInt("id"),resultSet.getInt("id_User"),resultSet.getDate("date"));
		});
	}
	//CREATE
	@Override
	public void createCommande(Commande c) {
		System.out.println("DAO: cr�ation du cours " + c.toString());

		Object[] arguments = new Object[2];
		arguments[0] = c.getIdUser();
		arguments[1] = c.getDate();	
	

		jdbcTemplate.update("INSERT INTO Commande ( id_user, date) VALUES ( ?, ?)", arguments);

	}
	
	@Override
	public void updateCommande(Commande c) {
		Object[] arguments = new Object[3];
		arguments[0] = c.getId();
		arguments[1] = c.getIdUser();
		arguments[2] = c.getDate();
		System.out.println(arguments[0].getClass().getName()+" "+ arguments[1].getClass().getName()+" "+arguments[2].getClass().getName());
		System.out.println(c.getIdUser());
		jdbcTemplate.update("UPDATE commande SET id_user=?, date=? WHERE id=?", arguments[1],arguments[2], arguments[0]);
	}

	@Override
	public List<Commande> getAllCommande() {
		return jdbcTemplate.query("Select * from commande", (resultSet, rowNum)->{
			return new Commande(resultSet.getInt("id"),resultSet.getInt("id_User"),resultSet.getDate("date"));
		});
	}

	@Override
	public void deleteCommande(int id) {
		jdbcTemplate.execute("Delete from commande where id ="+id);
		
	}
}
