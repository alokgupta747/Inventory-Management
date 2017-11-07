import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RetailerPO extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
		
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		System.out.println("hello");	
		out.println("<html><head><body bgcolor=lightyellow><center><b>Retailer PurchaseOrder</b><br><br><table>");
		out.println("<form action=./RetailerPO1 method=post>");

		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		                Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			System.out.println("con");
			Statement stmt=con.createStatement();
			out.println("<tr><td>PurchaseOrderDate:</td><td><input type=text name=Retailerdate></td></tr>");
			out.println("<tr><td>Cheque/DD:</td><td><input type=text name=Retailercheque></td></tr>");
			Statement stmt2=con.createStatement();
			ResultSet rs2=stmt2.executeQuery("select * from ITEM");
			out.println("<tr><td>ItemNo:</td><td><select name=s2>");
			   while(rs2.next())
			{
			out.println("<option>"+rs2.getInt(1)+"</option>");
			}
			out.println("</select></td></tr>");
			System.out.println("rs2");
			out.println("<tr><td>Quantity:</td><td><input type=text name=Retailerqty></td></tr>");
			out.println("<tr><td align=middle><input type=submit name=sub value=AddPurchaOrder></td></tr>");
			out.println("</form></table></center></body></html>");
			}catch(Exception e){e.printStackTrace();}
	       }
}