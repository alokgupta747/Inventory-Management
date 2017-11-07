import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewWHPurOrder extends HttpServlet
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
	     ResultSet rs=st.executeQuery("select a.WPOID,a.PAYDATE,a.SUPPLIERID,a.CHEQUENO,b.name from warehousepayment a,supplier b where a.supplierid=b.supplierid");
           out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>View WareHouse PurchaseOrder Status</b></u></font><br><br>");
	  out.println("<html><body bgcolor=lightyellow><table border=2>");
	  
	out.println("<tr><th>Purchase Id</th><th>PAYDATE</th><th>SUPPLIER</th><th>CHEQUENO</th></tr>");	     
	  
	while(rs.next())
	     {
				out.println("<tr><td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
		        out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td></tr>");
	}
 
	     out.println("</table>");
	     out.println("<a href=blank.html>Home</a>"); 	
	out.println("</body></html>");
	}catch(Exception e){e.printStackTrace();}
     }
}

	