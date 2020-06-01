package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.entities.Symtome;
import com.metier.implementation.SymptomeImpl;

/**
 * Servlet implementation class SymptomeController
 */
@WebServlet("/SymptomeController")
public class SymptomeController extends HttpServlet {
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
    public void init()
    {
    	symptomeImpl=new SymptomeImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("symptome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperation des informations
		String nom=request.getParameter("nom");
		String description=request.getParameter("description");
		//System.out.println(nom+""+description);
		Symtome  symptome=new Symtome(nom,description);
		//enregistrement du symptome223
		symptomeImpl.create_Symptome(symptome);
	}

}
