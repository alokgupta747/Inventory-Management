import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewItem extends HttpServlet
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
	     ResultSet rs=st.executeQuery("select * from ITEM");
	  out.println("<html><body bgcolor=lightyellow><table border=2>");
	out.println("<tr><th>ItemNo</th><th>ItemName</th><th>UnitCost</th></tr>");	     
	  
	while(rs.next())
	     {
		out.println("<tr><td>"+rs.getInt(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
		out.println("<td>"+rs.getDouble(3)+"</td>");
		}
             out.println("</table>");
	     out.println("<a href=viewitem.html>ViewSelectionForm</a>");
	     //out.println("<a href=./ListItem>Select</a>");	 	
	out.println("</body></html>");
	}catch(Exception e){e.printStackTrace();}
     }
}
  