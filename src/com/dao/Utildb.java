package com.dao;
import java.util.*;
import java.sql.*;


public class Utildb {
   private static Connection con=null;
   public static Connection getConnection(){
	   if(con!=null){
		   return con;
	   }
	   else{
             String Driver="com.mysql.jdbc.Driver";  
             String url="jdbc:mysql://localhost:3306/nlp";
             String user="root";
             String pass="root";
             try {
 				Class.forName(Driver);
 				con=DriverManager.getConnection(url,user,pass);
 				System.out.println("connection done...");
 			} catch (ClassNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			
	   }
	   return con;
   }
}
