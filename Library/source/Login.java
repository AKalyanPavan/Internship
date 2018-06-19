package library;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Login extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		String s1 = req.getParameter("user");
		String s2 = req.getParameter("paswd");
		try
		{
			String dburl = "jdbc:mysql://localhost:3306/project";
			String username="root";
			String password="";
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","");  
			PreparedStatement pst = con.prepareStatement("select * from user where name=? and password=?");
			pst.setString(1,s1);
			pst.setString(2,s2);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				String b1 = rs.getString("id");
				String b2 = rs.getString("name");
				String b3 = rs.getString("email");
				String b4 = rs.getString("phone");
				String b5 = rs.getString("password");
				res.getWriter().println("Login Successful");
				HttpSession session=req.getSession();  
		        session.setAttribute("id",b1);
		        session.setAttribute("us",b2);
		        session.setAttribute("em",b3);
		        session.setAttribute("pn",b4);
		        session.setAttribute("ps",b5);
		        res.sendRedirect("/library1/profile.html");
			}
			else
			{
				res.getWriter().println("invalid username or password");
			}
		}
		catch(Exception e)
		{
			res.getWriter().println(e.getMessage());
		}
	}
}
