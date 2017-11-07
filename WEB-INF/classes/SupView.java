import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SupView extends HttpServlet
{
       public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
         {
       try
	{
	    res.setContentType("text/html");
	    PrintWriter out=res.getWriter();
	            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from supplier");
	  out.println("<html><body bgcolor=lightyellow><table border=2>");
	out.println("<tr><th>SupNo</th><th>SupName</th><th>Phone</th><th>E-mail</th><th>House</th><th>Street</th><th>City</th><th>Country</th></tr>");	     
	  
	while(rs.next())
	     {
		out.println("<tr><td>"+rs.getInt(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
		out.println("<td>"+rs.getString(3)+"</td>");
		out.println("<td>"+rs.getString(4)+"</td>");
		out.println("<td>"+rs.getString(5)+"</td>");
		out.println("<td>"+rs.getString(6)+"</td>");
		out.println("<td>"+rs.getString(7)+"</td>");
		out.println("<td>"+rs.getString(8)+"</td></tr>");
	}
             out.println("</table>");
	     out.println("<a href=blank.html>Home</a>"); 	
	out.println("</body></html>");
	}catch(Exception e){e.printStackTrace();}
     }
}
  