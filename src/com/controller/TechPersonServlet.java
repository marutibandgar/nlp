package com.controller;

import it.cosenonjaviste.crypto.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Userbean;
import com.dao.Userdao;

/**
 * Servlet implementation class TechPersonServlet
 */
@WebServlet("/TechPersonServlet")
public class TechPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int workload = 12;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TechPersonServlet() {
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
		
		String name=request.getParameter("name"); 
		String password=request.getParameter("password");
		String pwd=hashPassword(password);
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		String language_id=request.getParameter("language_id");
		int lang_id=Integer.parseInt(language_id);
		//System.out.println("Language "+language_id);
		String language=request.getParameter("language");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String userStatus="technical";
		Userbean bean=new Userbean();
		bean.setName(name);
		bean.setPassword(pwd);
		bean.setEmail(email);
		bean.setMobile(mobile);
		bean.setLang_id(lang_id);
		bean.setDesignation(language);
		bean.setDob(dob);
		bean.setGender(gender);
		bean.setUserStatus(userStatus);
		int status=0;
		try {
			status = Userdao.addTechnician(bean);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(status>0){
			 out.println("<script type=\"text/javascript\">");  
			 out.println(" alert('Registration is Successful');");
			 out.println("</script>"); 
			 request.getRequestDispatcher("login.jsp").include(request, response);
			// RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
		      //  rd.forward(request, response);  
		 }
		 else{
			 out.print("Error");
		 }
		out.close();

	}

}
