import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WHDispatchOrder1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	try
	{
		 res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><b><u>DispatchOrder</u></b>");
		out.println("<form action=./WHDispatchOrder1 method=post>");
		out.println("<table>");
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from warehousesalesorder");
		out.println("<tr><th>PuchaseOrderNo</th><th>PaymentDate</th><th>ChequeNo</th></tr>");
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs1=st1.executeQuery("select * from sublocationpayment");
		rs.beforeFirst();
		while(rs.next())
		{
		if(rs.getString(4).equals("ok"))
		{
		        while(rs1.next())
		         {
			
			if(rs.getInt(1)==rs1.getInt(1))
			{		
				out.println("<tr><td>rs1.getInt(1)</td><td>rs1.getString(2)</td><td>rs1.getString(3)</td></tr>");
			}
			rs1.beforeFirst();
		         }
		}
	          }
	
	}catch(Exception e){e.printStackTrace();}
           }
}	   