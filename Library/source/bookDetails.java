package library;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

public class bookDetails extends HttpServlet
{
	 
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		try
	    { 
		    String dburl = "jdbc:mysql://localhost:3306/project";
		    String username="root";
		    String password="";
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		    PreparedStatement pst = con.prepareStatement("select * from books");
		    ResultSet rs = pst.executeQuery();
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int colnum = rsmd.getColumnCount();
		    while (rs.next()) 
			{
				for(int i = 1 ; i <= colnum; i++)
				{
					res.getWriter().print("</br>"+rs.getString(i) + "         ");
				}
				res.getWriter().println();
				res.getWriter().println("</br>----------------------------------------------------------------------------------------------------------");
		    }
//		   
		    res.getWriter().println("<a href='http://localhost:8080/library1/profile.html'><button>Profile</button></a>");
	    }
	    catch(Exception e)
	    {
	        res.getWriter().println(e.getMessage());
	    }
	}
			
}
