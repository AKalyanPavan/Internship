package library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		try
		{
		    HttpSession session=req.getSession();  
            session.invalidate();
            res.sendRedirect("/library1/index");
		}
		catch(Exception e)
		{
			res.getWriter().println(e.getMessage());
		}
	}
}
