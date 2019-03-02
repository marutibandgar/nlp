package com.controller;

import it.cosenonjaviste.crypto.BCrypt;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Utildb;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con=null;
	private static int workload=12;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String oldPwd=request.getParameter("password");
		String newPassword=request.getParameter("NewPassword");
		String newPwd=hashPassword(newPassword);
		String email=request.getParameter("email");
		try {
			Utildb dao=new Utildb();
			con=dao.getConnection();
			PreparedStatement ps1=con.prepareStatement("update users SET encrypted_password='"+newPwd+"' where email='"+email+"'");
			int status =ps1.executeUpdate();
			if(status>0){
			 //out.println("Password updated successfully");
			 //request.setAttribute("RattingMessage", "Rating updated successfully"); 
 	     	 //response.sendRedirect("/AnsweringNLP/login.jsp");
 	     	 
 	     	request.setAttribute("errorMessage", "Login using new Password"); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward( request, response);
			}
			else{
				out.print("Error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
