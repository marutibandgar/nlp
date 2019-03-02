package com.controller;

import it.cosenonjaviste.crypto.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Userdao;

import java.util.Random;

/**
 * Servlet implementation class userForgetPwdServlet
 */
@WebServlet("/userForgetPwdServlet")
public class userForgetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int workload=12;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userForgetPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		String email_id=request.getParameter("email");
	    String password="xyzabc";
	    String pwd="";
	    String userpassword=null;
	    char pwd1;
	    Random r = new Random();	
		
		try{
		ResultSet rs;
		String to=null;
	
		for (int i = 0; i < 10; i++) {
	    	pwd1=password.charAt(r.nextInt(password.length()));
	    	pwd=pwd+pwd1;
	    } 
		 System.out.println("Password  "+pwd);
	    userpassword=hashPassword(pwd);
	    rs=(ResultSet) Userdao.sendMailtoUserForget(email_id,userpassword); 			
			if(rs.next()){			    
				
			 to=rs.getString("email");  			
			String subject="Password";  
		    String msg="Your password is :"+pwd;  
		    Mailer.send(to,subject, msg);  
		    out.println("<script type=\"text/javascript\">");  
			out.println(" alert('message has been sent Successfully on your mailid');");
			out.println("</script>"); 
			request.getRequestDispatcher("login.jsp").include(request, response);//response.sendRedirect("login.jsp");
			}
			else if(rs.getFetchSize()==0){
				 out.println("<script type=\"text/javascript\">");  
				 out.println(" alert('Mail_id does not exists');");
				 out.println("</script>"); 
				 request.getRequestDispatcher("login.jsp").include(request, response);//response.sendRedirect("login.jsp"); response.sendRedirect("login.jsp");			  
			}
	        out.close();
				
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
