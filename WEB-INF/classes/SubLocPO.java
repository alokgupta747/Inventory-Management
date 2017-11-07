import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SubLocPO extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
		
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		System.out.println("hello");	
		out.println("<html><head><body bgcolor=lightyellow><center><b>SubLocation PurchaseOrder</b><br><br><table>");
		out.println("<form action=./SubLocPO1 method=post>");

		try
		{
			
			        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		                Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			System.out.println("con");
			Statement stmt=con.createStatement();
			out.println("<tr><td>PurchaseOrderDate:</td><td><input type=text name=SubLocdate></td></tr>");
			out.println("<tr><td>Cheque/DD:</td><td><input type=text name=SubLoccheque></td></tr>");
			Statement stmt2=con.createStatement();
			ResultSet rs2=stmt2.executeQuery("select * from ITEM");
			out.println("<tr><td>Item:</td><td><select name=s2>");
			   while(rs2.next())
			{
			out.println("<option value="+rs2.getInt(1)+">"+rs2.getString(2)+"</option>");
			}
			out.println("</select></td></tr>");
			System.out.println("rs2");
			out.println("<tr><td>Quantity:</td><td><input type=text name=SubLocqty></td></tr>");
			out.println("<tr><td align=middle><input type=submit name=sub value=AddPurchaOrder></td></tr>");
			out.println("</form></table></center></body></html>");
			}catch(Exception e){e.printStackTrace();}
	       }
}