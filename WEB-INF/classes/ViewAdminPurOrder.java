import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewAdminPurOrder extends HttpServlet
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
	     ResultSet rs=st.executeQuery("select * from warehousepayment");
	  out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>View WareHouse PurchaseOrder Status</b></u></font><br><br>");
	out.println("<tr><th>WPOID</th><th>PAYDATE</th><th>SUPPLIERID</th><th>CHEQUENO</th></tr>");	     
	  
	while(rs.next())
	     {
                out.println("<tr><td>"+rs.getInt(1)+"</td>");
		out.println("<tr><td>"+rs.getString(2)+"</td>");
		
                out.println("<td>"+rs.getInt(3)+"</td>");
		out.println("<td>"+rs.getString(4)+"</td>");
                
	}
             out.println("</table>");
	     out.println("<a href=blank.html>Home</a>"); 	
	out.println("</body></html>");
	}catch(Exception e){e.printStackTrace();}
     }
}
