package com.metier.implementation;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metier.Interface.AgentInterface;
import com.metier.entities.Agent;
import com.metier.entities.SingletonConnecction;

public class AgentImpl implements AgentInterface {

	Connection connection = SingletonConnecction.getConnexion();
	@Override
	public void create_agent(Agent agent) {
		// TODO Auto-generated method stub
		/*Recuperationde la connxion avec la BD*/
		try {
			PreparedStatement ps =  connection.prepareStatement("INSERT INTO AGENTS (id_user_agent,phone,descripiton) values(?,?,?)");
			ps.setInt(1, agent.getUser_id());
			ps.setInt(2, agent.getPhone());
			ps.setString(3, agent.getDescription());
			
			ps.executeUpdate();
			System.out.println("Agent créer avec succes!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update_agent(Agent agent) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps =  connection.prepareStatement("UPDATE AGENTS set id_user_agent=?,phone=?,descripiton=? where id=?");
			ps.setInt(1, agent.getUser_id());
			ps.setInt(2, agent.getPhone());
			ps.setString(3, agent.getDescription());
			ps.setInt(4, agent.getId());
			
			ps.executeUpdate();
			System.out.println("Agent mis à jour  avec succes!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete_agent(Agent agent) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps =  connection.prepareStatement("DELETE FROM AGENTS where id=?");
			ps.setInt(1, agent.getId());
			ps.executeUpdate();
			System.out.println("Agent supprimé avec succes!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Agent find_agent(int agent_id) {
		// TODO Auto-generated method stub
		Agent agent = null;
		try {
			PreparedStatement ps =  connection.prepareStatement("SELECT * FROM AGENTS as A USERS as U where id=? AND A.id_user_agent=U.id");
			ps.setInt(1, agent_id);
			
			/*recuperation du resultat*/
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				/*si l objet dans la base de donnée */
				agent = new Agent();
				
				/*Recuperation des attributs*/
				agent.setId(rs.getInt("id"));
				agent.setUser_id(rs.getInt("user_id"));
				agent.setPhone(rs.getInt("phone"));
				agent.setDescription(rs.getString("descripiton"));
				
				System.out.println("Recherche de l Agent terminer");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agent;
	}

	@Override
	public List<Agent> list_agent() {
		// TODO Auto-generated method stub
		//au debut la liste des symptomes est vide
				List<Agent> list_agent = new ArrayList<>();
				Agent agent = null;
				try {
					PreparedStatement ps =  connection.prepareStatement("SELECT * FROM AGENTS");
					
					/*recuperation du resultat*/
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						/*si l objet dans la base de donnée on construit un nouveau symptome */
						agent = new Agent();
						
						/*Recuperation des attributs*/
						agent.setId(rs.getInt("id"));
						agent.setPhone(rs.getInt("phone"));
						agent.setDescription(rs.getString("descripiton"));
						
						/* On ajoute le symptome dans la liste*/
						list_agent.add(agent);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				
				return list_agent;
	}

}
