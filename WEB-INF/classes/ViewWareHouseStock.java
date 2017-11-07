import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewWareHouseStock extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><u><b>Stock Details</b></u>");
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement();
		out.println("<table border=1 bordercolor=red>");
		out.println("<tr><th>ITEMID</th><th>ITEM Name</th><th>Quantity</th></tr>");
		ResultSet rs=st.executeQuery("select w.itemid,i.itemname,w.qty from warehousestock w,item i where w.itemid=i.itemid order by w.itemid");
		while(rs.next())
		{
		out.println("<tr><td>"+rs.getInt(1)+"</td>");
		out.println("<td>"+rs.getString(2)+"</td>");
		out.println("<td>"+rs.getInt(3)+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center></body></html>");
		}catch(Exception e){e.printStackTrace();}
	}
}