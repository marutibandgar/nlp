package com.controller;

import it.cosenonjaviste.crypto.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Userbean;
import com.dao.Utildb;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int workload = 12;
	private static  Connection con;
   
    public LoginServlet() {
        super();        
    }

    public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
       
		return(hashed_password);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email"); 
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		//String pwd=hashPassword(password);
		
		
		Userbean bean=new Userbean();
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setUserStatus(type);
		int status=0;
		try {
			String query = "select * from users where email='" + email + "'";
			String plaintext = bean.getPassword();
			boolean password_verified = false;
			String userType=null;;
			try {
				Utildb dao = new Utildb();
				con = dao.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
                 System.out.println("!!!!!!!!!!11111111111111"+email+"Password"+plaintext);
					password_verified = BCrypt.checkpw(plaintext, rs.getString(3));

					if (password_verified)
						status = 1;
					System.out.println("Status  :"+status);
					userType=rs.getString(8);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
		 if(status>0 && userType.equals("user")){
			 request.getSession().setAttribute("uname",email);
		  
			 out.println("<script type=\"text/javascript\">");  
			 out.println(" alert('Login is Successful');");
			 out.println("</script>"); 
			 request.getRequestDispatcher("user.jsp").include(request, response);
			// response.sendRedirect("user.jsp");
		 }
		 else if(status>0 && userType.equals("technical")){
			 request.getSession().setAttribute("uname",email); 
		  
			 out.println("<script type=\"text/javascript\">");  
			 out.println(" alert('Login is Successful');");
			 out.println("</script>"); 
			 request.getRequestDispatcher("TechnicalPer.jsp").include(request, response);
			 //response.sendRedirect("TechnicalPer.jsp");
		 }
		 else if(status>0 && userType.equals("admin")){
			 request.getSession().setAttribute("uname",email);
		  
			 out.println("<script type=\"text/javascript\">");  
			 out.println(" alert('Login is Successful');");
			 out.println("</script>"); 
			request.getRequestDispatcher("admin.jsp").include(request, response);
			// response.sendRedirect("admin.jsp");
			  
		 }
		 else {
			 request.setAttribute("errorMessage", "Invalid username or password"); 
             RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
             dispatcher.forward( request, response);
			
			  		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();	}

	

}
