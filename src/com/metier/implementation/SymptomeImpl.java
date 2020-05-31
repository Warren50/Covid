package com.metier.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.metier.Interface.SymptomeInterface;
import com.metier.entities.SingletonConnecction;
import com.metier.entities.Symtome;

public class SymptomeImpl implements SymptomeInterface{

	Connection connection = SingletonConnecction.getConnexion();
	@Override
	public void create_symptome(Symtome symptome) {
		// TODO Auto-generated method stub
		/*Recuperationde la connxion avec la BD*/
			try {
				PreparedStatement ps =  connection.prepareStatement("INSERT INTO SYMPTOMS(name,description) values(?,?)");
				ps.setString(1, symptome.getNom());
				ps.setString(2, symptome.getDescription());
				
				ps.executeUpdate();
				System.out.println("Symptome créer avec succes!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void update_symptome(Symtome symptome) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps =  connection.prepareStatement("UPDATE SYMPTOMS set name=?,description=? where id=?");
			ps.setString(1, symptome.getNom());
			ps.setString(2, symptome.getDescription());
			ps.setInt(3, symptome.getId());
			
			ps.executeUpdate();
			System.out.println("Symptome mis à jour  avec succes!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void delete_symptome(Symtome symptome) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps =  connection.prepareStatement("DELETE FROM SYMPTOMS where id=?");
			ps.setInt(1, symptome.getId());
			ps.executeUpdate();
			System.out.println("Symptome supprimé avec succes!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Symtome find_symptone(int symptome_id) {
		// TODO Auto-generated method stub
		Symtome symptome = null;
		try {
			PreparedStatement ps =  connection.prepareStatement("SELECT * FROM SYMPTOMS where id=?");
			ps.setInt(1, symptome_id);
			
			/*recuperation du resultat*/
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				/*si l objet dans la base de donnée */
				symptome = new Symtome();
				
				/*Recuperation des attributs*/
				symptome.setId(rs.getInt("id"));
				symptome.setNom(rs.getString("name"));
				symptome.setDescription(rs.getString("description"));
				
				System.out.println("Recherche du Symptome terminer");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return symptome;
	}

	@Override
	public List<Symtome> list_symptome() {
		// TODO Auto-generated method stub
		//au debut la liste des symptomes est vide
		List<Symtome> list_symptome = new ArrayList<>();
		Symtome symptome = null;
		try {
			PreparedStatement ps =  connection.prepareStatement("SELECT * FROM SYMPTOMS");
			
			/*recuperation du resultat*/
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				/*si l objet dans la base de donnée on construit un nouveau symptome */
				symptome = new Symtome();
				
				/*Recuperation des attributs*/
				symptome.setId(rs.getInt("id"));
				symptome.setNom(rs.getString("name"));
				symptome.setDescription(rs.getString("description"));
				
				/* On ajoute le symptome dans la liste*/
				list_symptome.add(symptome);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return list_symptome;
	}

}
