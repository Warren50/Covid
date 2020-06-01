package com.metier.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.metier.Interface.SymptomeInterface;
import com.metier.entities.SingletonConnecction;
import com.metier.entities.Symtome;


public class SymptomeImpl implements SymptomeInterface{

	@Override
	public void create_Symptome(Symtome sem) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into symptoms(NAME,DESCRIPTION) values(?,?)");
			ps.setString(1, sem.getNom());
			ps.setString(2, sem.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update_Symptome(Symtome sem) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps =conn.prepareStatement("update symptoms set name=?,description=? where id=?");
			ps.setString(1, sem.getNom());
			ps.setString(2, sem.getDescription());
			ps.setInt(3, sem.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete_symptome(Symtome sem) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps =conn.prepareStatement("delete from symptoms where id=?");
			ps.setInt(1, sem.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Symtome find_Symptome(int symptome_id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		Symtome sym =new Symtome();
		
		try {
			PreparedStatement ps =conn.prepareStatement("select * from symptoms where id=?");
			ps.setInt(1,symptome_id);
			//recuperation de resultats
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{	sym.setNom(rs.getString("NAME"));
				sym.setDescription(rs.getString("DESCRIPTION"));
				sym.setId(symptome_id);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sym;
	}

	@Override
	public List<Symtome> liste_symptome() {
		// TODO Auto-generated method stub
		List<Symtome> listeSymptome =new ArrayList<Symtome>();
		Connection conn=SingletonConnecction.getConnexion();
		
		try {
			PreparedStatement ps =conn.prepareStatement("select * from symptoms");
			//recuperation de resultats
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{	
				Symtome sym=new Symtome();
				sym.setNom(rs.getString("NAME"));
				sym.setDescription(rs.getString("DESCRIPTION"));
				sym.setId(rs.getInt("id"));
				listeSymptome.add(sym);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeSymptome;
	}

}
