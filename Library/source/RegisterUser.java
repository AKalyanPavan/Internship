package library;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class RegisterUser extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
         StringBuilder salt = new StringBuilder();
         Random rnd = new Random();
         while (salt.length() < 18) 
         { 
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
         }
         String a1 = salt.toString();
		 String a2 = req.getParameter("un");
    	 String a3 = req.getParameter("eid");
    	 String a4 = req.getParameter("phn").toString();
    	 String a5 = req.getParameter("ps");
    	 try
    	 {
    		String dburl = "jdbc:mysql://localhost:3306/project";
  			String username="root";
  			String password="";
  			Class.forName("com.mysql.jdbc.Driver");  
  			Connection con=DriverManager.getConnection(  
  			"jdbc:mysql://localhost:3306/project","root","");  
  			String query = "insert into user values(?,?,?,?,?)";
  			PreparedStatement ps = con.prepareStatement(query);
  			ps.setString(1, a1);
  		    ps.setString(2, a2);
  		    ps.setString(3, a3);
  		    ps.setString(4, a4);
  		    ps.setString(5, a5);
  		    ps.executeUpdate();
  		    res.sendRedirect("/library1/login.html");;
    	 }
    	 catch(Exception e)
    	 {
    		 res.getWriter().println(e.getMessage());
    	 }
	}
}
