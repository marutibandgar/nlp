package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  		
	    PrintWriter out = response.getWriter();  
	    System.out.println("In send mail Servlet");	
	    String btn=request.getParameter("submit");
	    		System.out.println("Button = "+btn);
	    String to=request.getParameter("to");  
	    System.out.println("Mail to: "+to);
	    String subject=request.getParameter("subject");  
	    String msg=request.getParameter("msg");  
	          
	    Mailer.send(to,subject, msg);  
	   
	      
	    request.setAttribute("Message", "mail has been sent successfully"); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mail_compose.jsp");
        dispatcher.forward( request, response);
		
	out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
