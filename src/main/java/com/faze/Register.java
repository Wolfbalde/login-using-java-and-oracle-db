package com.faze;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Crypt a=new Crypt();
			response.setContentType("text/html");
			String name = request.getParameter("x");
			String gender = request.getParameter("y");
			String dob = request.getParameter("z");
			String email = request.getParameter("mail");
			String pass = request.getParameter("pass");
			PrintWriter pw = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Akaash", "maximo");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Deets");
			while (rs.next()) {
				String mail = rs.getString("Email");
				if (mail.equals(email)) {
					pw.print("Email already registered!!!. Click here to ");
					pw.print("<a href='Register.jsp'>Register</a>");
					pw.println("Click here to ");
					pw.print("<a href='index.jsp'>Login</a>");
				} 
			}
			PreparedStatement ps = con.prepareStatement("insert into Deets values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, dob);
			ps.setString(4, email);
			ps.setString(5, a.encrypt(pass));
			ps.executeUpdate();
			pw.print("<a href='index.jsp'>Login</a>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
