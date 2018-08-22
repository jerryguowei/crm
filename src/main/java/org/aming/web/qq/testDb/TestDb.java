package org.aming.web.qq.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="duduanan"; //your database name
		String pass="duduanan"; //your datebase password;		
		String jdbcUrl="jdbc:mysql://localhost:3306/webqq?useSSL=false";
		String driver="com.mysql.jdbc.Driver";		
		try{
			   PrintWriter out=response.getWriter();
			   out.println("Connecting to database: " + jdbcUrl);
			   Class.forName(driver);
			   Connection myConnection= DriverManager.getConnection(jdbcUrl,user,pass);
			   out.println("Success!");
			   myConnection.close();
		}catch (Exception ex) {
           ex.printStackTrace();
           throw new ServletException(ex);        
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
