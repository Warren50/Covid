package com.web.controller;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.entities.Symtome;
import com.metier.implementation.SymptomeImpl;

@WebServlet("/SymptomeController")
public class SymptomeController extends HttpServlet {
	
	/*Instanciation de notre couche metier*/
	SymptomeImpl symptomeImpl;
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	public SymptomeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(){
		//Initialisation de notre couche metier
		symptomeImpl = new SymptomeImpl();
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperation de la vue
		request.getRequestDispatcher("symptome.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*Recuperation des champs de la vue*/
		
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		
		//on construit l'objet
		Symtome symptome = new Symtome(nom, description);
		
		/*Enregistrement du symptome dans la BD*/
		symptomeImpl.create_symptome(symptome);
	}
}
