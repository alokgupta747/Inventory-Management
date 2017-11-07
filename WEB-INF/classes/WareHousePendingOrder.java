import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WareHousePendingOrder extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
      	try
	      {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse PendingOrder</b></u></font>");
		out.println("<form>");
		  }
		  catch(Exception e)
		{}
	}}
		