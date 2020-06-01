package com.web.controller;

import java.io.IOException;
import java.util.List;

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
		//request.setAttribute("mod", new ReceiverModel());
		ReceiverModel model=new ReceiverModel();
		request.setAttribute("model", model);
		  List<Receiver> receivers=receiver.liste_Receiver();
			model.setListeReceive(receivers);
			request.getRequestDispatcher("receiver.jsp").forward(request, response); 
		doPost(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		ReceiverModel model=new ReceiverModel();
		request.setAttribute("model", model);
		if(action!=null){
			if(action.equals("ajouter")){
				  List<Receiver> receivers=receiver.liste_Receiver();
					model.setListeReceive(receivers);
				
					
				//recuperation des informations Integer.parseInt(req.getParameter("test"))
				int user=Integer.parseInt( request.getParameter("user"));
				int phone=Integer.parseInt(request.getParameter("phone"));
				int code=Integer.parseInt(request.getParameter("code"));
				 Receiver rec =new Receiver(975,user,3, phone,code);
			       receiver.create_Receiver(rec);
			       model.setListeReceive(receiver.liste_Receiver());
			       request.getRequestDispatcher("receiver.jsp").forward(request, response); 
			     
			}
			else if(action.equals("delete")){
				int id =Integer.parseInt(request.getParameter("ref"));
				 receiver.delete_Receiver(id);
				 model.setListeReceive(receiver.liste_Receiver());
				 request.getRequestDispatcher("receiver.jsp").forward(request, response); 
			}
		}
		
	}

}
