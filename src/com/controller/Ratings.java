package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
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
import javax.xml.ws.Dispatch;

import org.omg.PortableInterceptor.DISCARDING;

import com.dao.Utildb;

/**
 * Servlet implementation class Ratings
 */
@WebServlet("/Ratings")
public class Ratings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static Connection con=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ratings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("action");
		String email=request.getParameter("email");
		
		String ans_id1=request.getParameter("ans_id");
		int ans_id=Integer.parseInt(ans_id1);
		int user_id=0;
		int rating=0;
		Boolean flag=false;		
		
		try{	
			Utildb dao=new Utildb();
			con=dao.getConnection();
			String query2="select user_id from users where email='"+email+"'";
			PreparedStatement ps2=con.prepareStatement(query2);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next()){
			  user_id=rs2.getInt(1);	
			}
			
			
			String query1="select rating from rating_info where user_id='"+user_id+"' and answer_id='"+ans_id+"' ";
			PreparedStatement ps3=con.prepareStatement(query1);
			ResultSet rs1=ps3.executeQuery();
			if(rs1.next()){
				flag=true;
			}
			
			
			if(btn.equals("likes") || btn.equals("dislikes")){		
				if(flag){
					request.setAttribute("RattingMessage", "Already given rating for this answer"); 
					 RequestDispatcher view = request.getRequestDispatcher("answer.jsp");	
					 view.forward(request, response);		 
				}
				
				else{
			  String query="select likes,dislikes from answers where answer_id='"+ans_id+"'";	
			  String query3="insert into rating_info(user_id,answer_id,rating)values('"+user_id+"','"+ans_id+"',1) ";
			  PreparedStatement ps4=con.prepareStatement(query3);
			  ps4.executeUpdate();
			  PreparedStatement ps=con.prepareStatement(query);					
			  ResultSet rs = ps.executeQuery();
			  
			  while(rs.next()){
			    rating= btn.equals("likes") ? rs.getInt("likes") : rs.getInt("dislikes");
			    rating++;
			    System.out.println("Rating "+rating);
			   }
			    PreparedStatement ps1=con.prepareStatement("update answers SET "+btn+" ='"+rating+"' where answer_id='"+ans_id+"'");
			    ps1.executeUpdate();
			  }
			
			  request.setAttribute("RattingMessage", "Rating updated successfully"); 
  	     	 // response.sendRedirect("/AnsweringNLP/QuestionInsert?question="+request.getParameter("question"));		
			  response.sendRedirect("answer.jsp");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	
		
		
	}

}
