package com.faze;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Crypt a=new Crypt();
			response.setContentType("text/html");
			String log = request.getParameter("L");
			String reg = request.getParameter("R");
			if (reg != null) {
				response.sendRedirect("Register.jsp");
			}
			String user = request.getParameter("login");
			String pas = request.getParameter("pas");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Akaash", "maximo");
			Statement st = con.createStatement();
			PrintWriter pw = response.getWriter();
			ResultSet rs = st.executeQuery("select * from Deets");
			while (rs.next()) {
				String name = rs.getString("Email");
				String pass = rs.getString("password");
				String org=a.decrypt(pass);
				String nam = rs.getString("name");
				if (name.equals(user)) {
					if (org.equals(pas)) {
						HttpSession session = request.getSession();
						session.setAttribute("uname", nam);
						response.sendRedirect("AfterLogin.jsp");
					} else {
						response.sendRedirect("Invalid.jsp");
					}
				} else {
					response.sendRedirect("Invalid.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
