package com.metier.entities;
//package com.metier.bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnecction {
	public static Connection connexion;
	
		static{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit2","root","");
				//System.out.println("Connexion effective !");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("pas vraiment bon");
			}
			
		}

		public static Connection getConnexion() {
			return connexion;
		}
		
	
}
