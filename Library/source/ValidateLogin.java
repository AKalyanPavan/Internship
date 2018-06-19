package library;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ValidateLogin extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession session = req.getSession();
		try
		{
			Object p1 = session.getAttribute("us"); 
		    Object p2 = session.getAttribute("ps");
		    res.getWriter().println(p1);
		    if(p1==null)
		    {
		    	res.sendRedirect("/library1/home.html");
		    	//req.getRequestDispatcher("/home.html").forward(req, res);
		    }
		    else
		    {
		    	res.sendRedirect("/library1/profile.html");
		    	//req.getRequestDispatcher("/profile.html").forward(req, res);
		    }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
