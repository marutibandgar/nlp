package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Userbean;
import com.dao.Userdao;

/**
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("In view User Servlet");
		String btn=request.getParameter("submit");
		
		if(btn.equals("UserDetails"))
		{

		  List<Userbean> bean = new ArrayList<Userbean>();
		  
		  int size=bean.size();
		  try {
			bean=Userdao.viewUser();
			request.getSession().setAttribute("bean1",bean);
			
			 RequestDispatcher rd=request.getRequestDispatcher("user_table.jsp");  
		        rd.forward(request, response);  
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 	else if(btn.equals("TechnicalPersonDetails"))
	{
		System.out.println("In view TechnicalPersonDetails Servlet");
		
		List<Userbean> bean1 = new ArrayList<Userbean>();
		 
		  bean1=Userdao.viewTechnicalPerson();
		  
		  int size=bean1.size();
		request.getSession().setAttribute("bean2",bean1);
		
		 RequestDispatcher rd=request.getRequestDispatcher("ViewTechnicalPerson.jsp");  
		    rd.forward(request, response);
     }
	 	else if(btn.equals("ADD_New_Question"))
		{
	 		System.out.println("In view Add New question Servlet");
			/* RequestDispatcher rd=request.getRequestDispatcher("AddQuestion.jsp");  
			    rd.forward(request, response);*/
	 		response.sendRedirect("AddQuestion.jsp");
	     }
	   else if(btn.equals("View_New_Question"))
			{
		       
				 RequestDispatcher rd=request.getRequestDispatcher("ViewNewQuestion.jsp");//  ViewNewQuestion.jsp
				    rd.forward(request, response);
		     }
}
}