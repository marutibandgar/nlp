package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Userbean;
import com.dao.Userdao;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
	   
		Userbean bean=new Userbean();
		bean.setEmail(email);
		bean.setMobile(mobile);
		
		Userdao dao=new Userdao();
		try {
			int st=dao.updateProfile(bean);
			
			if(st>0){
				
				 out.println("<script type=\"text/javascript\">");  
				 out.println(" alert('Profile updated Successful');");
				 out.println("</script>"); 
				 request.getRequestDispatcher("Userprofile.jsp").include(request, response);				  
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
