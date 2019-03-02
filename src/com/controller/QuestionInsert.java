package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Userbean;
import com.dao.Userdao;

/**
 * Servlet implementation class QuestionInsert
 */
@WebServlet("/QuestionInsert")
public class QuestionInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/Html");
		PrintWriter out=response.getWriter();
		
		String question=request.getParameter("question");
		String user =(String)request.getSession().getAttribute("uname");
		Userbean bean=new Userbean();
		bean.setQuestion(question);//what is jdbc
		
		ArrayList<Userbean> list =new ArrayList<Userbean>();
		
		list=Userdao.fetchAnswers(bean);
		
		
		if(list.isEmpty()){
			 System.out.println("List is Empty");
			 request.setAttribute("errorMessage", "Not available now  It will get you soon "); 
			 request.setAttribute("uname",user);
			// request.getSession().setAttribute("errorMessage","Not available now ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/answer.jsp");
             dispatcher.forward(request, response);
			
			
			
			 //RequestDispatcher dispatcher = request.getRequestDispatcher("/answer.jsp");
			// request.getRequestDispatcher("answer.jsp").include(request, response);
          //  dispatcher.forward( request, response);
			
		}else{
			request.getSession().setAttribute("bean",list);	
			 request.getRequestDispatcher("answer.jsp").include(request, response);
		//response.sendRedirect("answer.jsp");
		// RequestDispatcher rd=request.getRequestDispatcher("answer.jsp");  
		 //rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String question=request.getParameter("question");
		String user =(String)request.getSession().getAttribute("uname");
		
		Userbean bean=new Userbean();
		bean.setQuestion(question);
	//	int result=Userdao.insertHquestion(bean);			
				
		doGet(request, response);
	}

}
