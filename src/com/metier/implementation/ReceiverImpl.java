package com.metier.implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metier.Interface.*;
import com.metier.entities.Receiver;
import com.metier.entities.SingletonConnecction;
public class ReceiverImpl implements ReceiverInterface {

	@Override
	public void create_Receiver(Receiver rec) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into  receivers(CARD_ID,ID_USER_RECEIVER,ID_VALIDER,"
					+ "PHONE,CODE) values(?,?,?,?,?)");
			ps.setInt(1, rec.getCard_id());
			ps.setInt(2, rec.getId_user_receiver());
			ps.setInt(3, rec.getId_valider());
			ps.setInt(4, rec.getPhone());
			ps.setInt(5, rec.getCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update_Receiver(Receiver rec) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps =conn.prepareStatement("update receivers set CARD_ID=?,ID_USER_RECEIVER=?"
					+ ",ID_VALIDER=?,PHONE=?,CODE=? where id=?");
			ps.setInt(1, rec.getCard_id());
			ps.setInt(2, rec.getId_user_receiver());
			ps.setInt(3, rec.getId_valider());
			ps.setInt(4, rec.getPhone());
			ps.setInt(5, rec.getCode());
			ps.setInt(6, rec.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete_Receiver(int rec_id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		try {
			PreparedStatement ps =conn.prepareStatement("delete from receivers where id=?");
			ps.setInt(1, rec_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Receiver find_Receiver(int rec_id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnecction.getConnexion();
		Receiver rec =new Receiver();
		
		try {
			PreparedStatement ps =conn.prepareStatement("select * from receivers where id=?");
			ps.setInt(1,rec_id);
			//recuperation de resultats
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{	
				rec.setCard_id(rs.getInt("CARD_ID"));
				rec.setCode(rs.getInt("CODE"));
				rec.setId_user_receiver(rs.getInt("ID_USER_RECEIVER"));
				rec.setId_valider(rs.getInt("ID_VALIDER"));
				rec.setPhone(rs.getInt("PHONE"));
				rec.setId(rec_id);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rec;
	}

	@Override
	public List<Receiver> liste_Receiver() {
		// TODO Auto-generated method stub
		List<Receiver> listeReceiver =new ArrayList<Receiver>();
		Connection conn=SingletonConnecction.getConnexion();
		
		try {
			PreparedStatement ps =conn.prepareStatement("select * from receivers");
			//recuperation de resultats
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{	
				Receiver rec =new Receiver();
				rec.setCard_id(rs.getInt("CARD_ID"));
				rec.setCode(rs.getInt("CODE"));
				rec.setId_user_receiver(rs.getInt("ID_USER_RECEIVER"));
				rec.setId_valider(rs.getInt("ID_VALIDER"));
				rec.setPhone(rs.getInt("PHONE"));
				rec.setId(rs.getInt("id"));
				listeReceiver.add(rec);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeReceiver;
	}

}
