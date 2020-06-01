package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.metier.entities.Receiver;
import com.metier.implementation.ReceiverImpl;

/**
 * Servlet implementation class ReceiverController
 */
@WebServlet("/ReceiverController")
public class ReceiverController extends HttpServlet {
	ReceiverImpl receiver;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiverController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	receiver=new ReceiverImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("mod", new ReceiverModel());
		request.getRequestDispatcher("receiver.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperation des informations Integer.parseInt(req.getParameter("test"))
				int user=Integer.parseInt( request.getParameter("user"));
				int phone=Integer.parseInt(request.getParameter("phone"));
				int code=Integer.parseInt(request.getParameter("code"));
				 Receiver rec =new Receiver(5,user,3, phone,code);
			       receiver.create_Receiver(rec);
			
	}

}
