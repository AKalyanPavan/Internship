package library;

import java.io.IOException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditDetails extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		try
		{
			HttpSession session=req.getSession(false);
		    if(session!=null)
		    {  
		    	res.setContentType("text/html");  
		    	String p1=(String)session.getAttribute("id"); 
			    String p2=(String)session.getAttribute("us"); 
			    String p3=(String)session.getAttribute("em"); 
			    String p4=(String)session.getAttribute("pn");
			    String p5=(String)session.getAttribute("ps");
			    res.getWriter().println("<head><link rel='stylesheet' href='editdetails.css'></head>");
			    res.getWriter().println("<form method='get' action='submitDetails'>");
			    res.getWriter().println("<h1 align='center'>PROFILE PAGE</h1>");
			    res.getWriter().println("<input type='hidden' name='pg1' value='"+p1+"'></input></br>");
			    res.getWriter().println("<div class='line'>Username:<input type='text' name='pg2' value='"+p2+"'></input></br>");
			    res.getWriter().println("Email id:<input type='text' name='pg3' value='"+p3+"'></input></br>");
			    res.getWriter().println("Phone number:<input type='text' name='pg4' value='"+p4+"'></input></br>");
			    res.getWriter().println("Password:<input type='text' name='pg5' value='"+p5+"'></input></br></div>");
			    res.getWriter().println("<button id='mybutton' type='submit' class='b1'>Submit Details</button></form>");
//			    res.getWriter().println("<script>" + 
//			    		"function display()"
//			    		+ "{" + 
//			    		    "pg1.style.display = 'block'"+
//			    		  "}" + 
//			    		"</script>");
		    }
		    else
		    {
		    	res.getWriter().println("Please Login");
		    }
	    }
		catch(Exception e)
		{
			res.getWriter().println(e.getMessage());
		}
	}
}
