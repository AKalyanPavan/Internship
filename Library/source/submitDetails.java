package library;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

public class submitDetails extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String a1 = req.getParameter("pg1");
		String a2 = req.getParameter("pg2");
		String a3 = req.getParameter("pg3");
		String a4 = req.getParameter("pg4");
		String a5 = req.getParameter("pg5");
		try
		{
			String dburl = "jdbc:mysql://localhost:3306/project";
  			String username="root";
  			String password="";
  			Class.forName("com.mysql.jdbc.Driver");  
  			Connection con=DriverManager.getConnection(  
  			"jdbc:mysql://localhost:3306/project","root","");
  			PreparedStatement pst = con.prepareStatement("update user set name=?, email=?, phone=?, password=? where id=?;");
			pst.setString(1,a2);
			pst.setString(2,a3);
			pst.setString(3,a4);
			pst.setString(4,a5);
			pst.setString(5,a1);
			pst.executeUpdate();
			HttpSession session=req.getSession();  
	        session.setAttribute("id",a1);
	        session.setAttribute("us",a2);
	        session.setAttribute("em",a3);
	        session.setAttribute("pn",a4);
	        session.setAttribute("ps",a5);
			res.sendRedirect("/library1/profile.html");
		}
		catch(Exception e)
		{
			res.getWriter().println(e.getMessage());
		}
	}
}
