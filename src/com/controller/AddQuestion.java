package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Utildb;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.sql.*;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestion() {
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
	
	HttpSession session=null;
	String question=request.getParameter("question");
	String email=request.getParameter("email");
	String language_id=request.getParameter("language_id");
	System.out.println("Language ID  :"+language_id);
	try {
		Utildb dao=new Utildb();
		  con=dao.getConnection();
		 PreparedStatement ps=(PreparedStatement) con.prepareStatement("select user_id from users where email='"+email+"'"); 
		  java.sql.ResultSet rs=ps.executeQuery();
		  int user_id=0;
		  while(rs.next()){
			 user_id= rs.getInt(1);
		  }
		  String status="active";
		  String query="insert into questions(statement,status,user_id,Technology)values('"+question+"','"+status+"','"+user_id+"','"+language_id+"') ";
		  PreparedStatement ps1=(PreparedStatement) con.prepareStatement(query);
		  
			    int status1=ps1.executeUpdate();
		  
			    if(status1>=1){
			    	request.setAttribute("Message", "Question inserted successfully"); 
		             RequestDispatcher dispatcher = request.getRequestDispatcher("/AddQuestion.jsp");
		             dispatcher.forward( request, response);
					
			    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	
	}

}
