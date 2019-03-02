package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Userbean;
import com.dao.*;
/**
 * Servlet implementation class UpdateAnswer
 */
@WebServlet("/UpdateAnswer")
public class UpdateAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnswer() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
			
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String id=request.getParameter("id");
		String que_id1=request.getParameter("que_id");
		int que_id=Integer.parseInt(que_id1);
		
		System.out.println("Question ID"+que_id);
		String email=request.getParameter("email");
		
		Userbean bean=new Userbean();
		bean.setQuestion(question);
		bean.setAnswer(answer);
		bean.setEmail(email);
		
		bean.setQue_id(que_id);		
		int status=0;
		try {
			status = Userdao.updateAnswer(bean);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(status>0){
			System.out.println("In Update");
			 out.println("<script type=\"text/javascript\">");  
			 out.println(" alert('Answer Update Successfully');");
			 out.println("</script>"); 
			 request.getRequestDispatcher("TechnicalPer.jsp").include(request, response);
			//RequestDispatcher view = request.getRequestDispatcher("TechnicalPer.jsp");
	        //view.forward(request, response);
		}
	}
	}


