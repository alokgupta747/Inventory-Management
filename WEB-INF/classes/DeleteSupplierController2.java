import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class DeleteSupplierController2 extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
     resp.setContentType("text/html");
     //String id1=req.getParameter("op1");
     int id=Integer.parseInt(req.getParameter("s1"));
	System.out.println("id"+id);
     PrintWriter out=resp.getWriter();
    try
     {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	Statement stmt=con.createStatement();
	int i=stmt.executeUpdate("delete supplier where SUPPLIERID="+id);
	System.out.println("Deleted id has selected");
	if(i==1)
	{
		out.println("<font face=verdana color=red size=3>Supplier Deleted Successfully</font>");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
	}
	else
 	{
		out.println("<font face=verdana color=red size=3>Supplier Deletion Failed</font>");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
	}
	out.close();
	stmt.close();
	con.close();
 	}catch(Exception e){e.printStackTrace();
			out.println("<font face=verdana color=red size=3>Supplier Deletion Failed</font>");
		resp.setHeader("Refresh","2;URL=./choosesup.html");
}
   }
}
