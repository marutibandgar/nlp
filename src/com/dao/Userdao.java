package com.dao;

import it.cosenonjaviste.crypto.BCrypt;

import com.algorithm.StopWordRemove;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.algorithm.C4_5;
import com.bean.Userbean;

public class Userdao {

	static Connection con = null;

	public static int addUser(Userbean bean) {
		int status = 0;
		try {

			String d = bean.getDob();
			System.out.println("Date" + d);
			java.util.Date date = new SimpleDateFormat("dd-mm-yyyy").parse(d);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			String query = "insert into users(name,encrypted_password,email,mobile,dob,gender,usertype,status,salt)values(?,?,?,?,?,?,?,?,?)";
			Utildb dao = new Utildb();
			con = dao.getConnection();

			PreparedStatement ps1 = con.prepareStatement(query);

			ps1.setString(1, bean.getName());
			ps1.setString(2, bean.getPassword());
			ps1.setString(3, bean.getEmail());
			ps1.setString(4, bean.getMobile());
			ps1.setDate(5, sqlDate);
			ps1.setString(6, bean.getGender());
			ps1.setString(7, bean.getUserStatus());
			ps1.setString(8, "active");
			ps1.setInt(9, 12);
			status = ps1.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception " + e);
		}

		return status;
	}

	public static int addTechnician(Userbean bean) throws ParseException {
		int status = 0;
		String d = bean.getDob();
		try {
			System.out.println("Date" + d);
			java.util.Date date = new SimpleDateFormat("dd-mm-yyyy").parse(d);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String query = "insert into users(name,encrypted_password,email,mobile,dob,gender,usertype,Designation,status,salt)values(?,?,?,?,?,?,?,?,?,?)";
			Utildb dao = new Utildb();
			con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());

			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getMobile());
			ps.setDate(5, sqlDate);
			ps.setString(6, bean.getGender());
			ps.setString(7, bean.getUserStatus());
			ps.setString(8, bean.getDesignation());
			ps.setString(9, "active");
			ps.setInt(10, 12);

			status = ps.executeUpdate();

			String user_data = "select * from users where email='"
					+ bean.getEmail() + "'";
			PreparedStatement ps1 = con.prepareStatement(query);
			ResultSet rs1 = ps1.executeQuery(user_data);
			int language_id = bean.getLang_id();

			/*
			 * while(rs1.next()){ int id1=rs1.getInt(1);
			 * System.out.println(" User Id"+id1); String
			 * query1="insert into user_languages(user_id,language_id)values(?,?)"
			 * ; PreparedStatement ps2=con.prepareStatement(query1);
			 * ps2.setInt(1, id1); ps2.setInt(2, language_id); status=
			 * ps2.executeUpdate(); }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static List<Userbean> viewQuestion(String email) throws SQLException {
		List<Userbean> list = new ArrayList<Userbean>();
		String query1 = "select Designation from users where email='" + email
				+ "'";

		Utildb dao = new Utildb();
		con = dao.getConnection();
		PreparedStatement ps1 = con.prepareStatement(query1);
		ResultSet rs1 = ps1.executeQuery();
		String language = null;
		while (rs1.next()) {
			language = rs1.getString(1);
		}

		String query = "select * from questions where Technology='" + language
				+ "'";

		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Userbean bean = new Userbean();

			bean.setQuestion(rs.getString("statement"));
			int id = rs.getInt("user_id");
			int que_id = rs.getInt("question_id");
			bean.setId(id);
			bean.setQue_id(que_id);

			list.add(bean);
		}

		return list;
	}

	public static int addAnswer(Userbean bean) {

		int status1 = 0;
		int que_id = bean.getQue_id();
		int user_id1 = 0;
		try {
			String query2 = "select user_id from users where email='"
					+ bean.getEmail() + "'";
			Utildb dao = new Utildb();
			con = dao.getConnection();
			PreparedStatement ps3 = con.prepareStatement(query2);
			ResultSet rs2 = ps3.executeQuery();
			if (rs2.next()) {
				user_id1 = rs2.getInt(1);
			}

			String status = "active";

			String query = "insert into answers(question_id,statement,status,user_id) values('"
					+ que_id
					+ "','"
					+ bean.getAnswer()
					+ "','"
					+ status
					+ "','" + user_id1 + "')";
			PreparedStatement ps1 = con.prepareStatement(query);
			status1 = ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status1;
	}

	public static int updateAnswer(Userbean bean) {

		int status1 = 0;
		int que_id = bean.getQue_id();
		int user_id1 = 0;
		try {

			System.out.println("In Update in Userdao");
			String query2 = "select user_id from users where email='"
					+ bean.getEmail() + "'";
			Utildb dao = new Utildb();
			con = dao.getConnection();
			PreparedStatement ps3 = con.prepareStatement(query2);
			ResultSet rs2 = ps3.executeQuery();
			if (rs2.next()) {
				user_id1 = rs2.getInt(1);
			}

			String query = "update answers set likes=0,dislikes=0,statement ='"
					+ bean.getAnswer() + "'where question_id='" + que_id
					+ "'and user_id='" + user_id1 + "'";
			PreparedStatement ps1 = con.prepareStatement(query);
			status1 = ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status1;
	}

	public static List<Userbean> viewUser() throws SQLException {
		List<Userbean> list = new ArrayList<Userbean>();
		try {
			String usertype = "user";
			String query = "select * from users where usertype='" + usertype
					+ "' ";
			System.out.println(query);
			Utildb dao = new Utildb();
			con = dao.getConnection();
			// ResultSet rs = con.createStatement().executeQuery(query);
			PreparedStatement ps3 = con.prepareStatement(query);
			ResultSet rs = ps3.executeQuery(query);
			while (rs.next()) {
				System.out.println("Name" + rs.getString(2));
				Userbean bean = new Userbean();

				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getString(5));
				bean.setGender(rs.getString(6));
				java.sql.Date d = rs.getDate(7);
				System.out.println(d);
				DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
				String strDate = dateFormat.format(d);
				bean.setDob(strDate);

				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static List<Userbean> viewTechnicalPerson() {
		List<Userbean> list = new ArrayList<Userbean>();
		try {
			String usertype = "technical";
			String query = "select * from users where usertype='" + usertype
					+ "' ";
			Utildb dao = new Utildb();
			con = dao.getConnection();
			ResultSet rs = con.createStatement().executeQuery(query);
			while (rs.next()) {

				Userbean bean = new Userbean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getString(5));
				bean.setGender(rs.getString(6));
				java.sql.Date d = rs.getDate(7);
				DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
				String strDate = dateFormat.format(d);
				bean.setDob(strDate);
				bean.setDesignation(rs.getString(9));

				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet sendMailtoUserForget(String email, String pwd)
			throws SQLException {
		System.out.println("Password  " + pwd);
		Utildb dao = new Utildb();
		String query = "select * from users where email='" + email + "'";
		String query1 = "update users set encrypted_password='" + pwd
				+ "' where email='" + email + "'";
		con = dao.getConnection();
		PreparedStatement ps1 = con.prepareStatement(query1);
		ps1.executeUpdate();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = con.createStatement().executeQuery(query);
		return rs;
	}

	public Userbean delete(int userId) {
		Userbean userbean = new Userbean();
		try {
			String sql = "DELETE FROM users WHERE user_id=" + userId + "";
			Utildb dao = new Utildb();
			con = dao.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userbean;
	}

	public static ResultSet viewProfile(String email) throws SQLException {
		ResultSet rs = null;
		try {
			System.out.println("Email  : " + email);
			Utildb dao = new Utildb();
			con = dao.getConnection();
			String query = "select * from users where email='" + email + "'";
			rs = con.createStatement().executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public static int updateProfile(Userbean bean) throws SQLException {
		ResultSet rs = null;
		int st = 0;
		try {
			System.out.println("Email  : " + bean.getEmail());
			Utildb dao = new Utildb();
			con = dao.getConnection();
			String query1 = "update users set email ='" + bean.getEmail()
					+ "', mobile='" + bean.getMobile() + "' where email='"
					+ bean.getEmail() + "'";
			PreparedStatement ps = con.prepareStatement(query1);
			st = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public static int insertHquestion(Userbean bean) {
		Utildb dao = new Utildb();
		con = dao.getConnection();
		String Query = "INSERT INTO users_history (statement,user_id,email )VALUES('"
				+ bean.getQuestion()
				+ "',(SELECT user_id FROM users WHERE email ='"
				+ bean.getEmail() + "'),'" + bean.getEmail() + "')";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<Userbean> fetchAnswers(Userbean bean) {

		System.out.println("In Userdao");
		ResultSet rs = null;
		// String question="Why multiple inheritance is not supported in java?";

		StopWordRemove obj = new StopWordRemove();
		String search_parameter = obj.stopword(bean.getQuestion());//
		// String jdbc=obj.stopword("What is ?");
		// String search_parameter=obj.stopword("What is data encapsulation?");

		System.out.println("In Userdao : " + search_parameter);
		double d = 0.0;
		int q_id = 0;
		String que = null;

		Utildb dao = new Utildb();
		con = dao.getConnection();

		ArrayList<Userbean> list = new ArrayList<Userbean>();
		String query = "select * from questions";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			C4_5 st = new C4_5();

			while (rs.next()) {
				que = rs.getString(2);
				q_id = rs.getInt(1);

				d = st.printDistance(search_parameter, obj.stopword(que));
				System.out.println("Matching String Percentage  :" + d);

				if (d > 30.0) {
					String query1 = "select * from answers where question_id='"
							+ q_id + "'ORDER BY likes DESC";
					PreparedStatement ps1 = con.prepareStatement(query1);
					ResultSet rs2 = ps1.executeQuery();

					while (rs2.next()) {
						Userbean ub = new Userbean();
						ub.setQuestion(que);
						ub.setQue_id(q_id);
						ub.setAns_id(rs2.getInt(1));
						ub.setAnswer(rs2.getString(3));
						ub.setLike(rs2.getInt(6));
						ub.setDislike(rs2.getInt(7));
						list.add(ub);
					}

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
