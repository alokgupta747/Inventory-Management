import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WHDispatchOrder extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	try
	{
		 res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><b><u>DispatchOrder</u></b>");
		out.println("<form action=./WHPurchaseOrder1 method=post>");
		out.println("<table>");
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from warehousesalesorder");
		/*out.println("<tr><th>PuchaseOrderNo</th><th>PaymentDate</th><th>ChequeNo</th></tr>");
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs1=st1.executeQuery("select * from sublocationpayment");
                Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
               ResultSet rs2=st2.executeQuery("select * from slpurchaseorder");
               rs2.beforeFirst();*/

		rs.beforeFirst();
                out.println("<table>");
                
		out.println("<tr><td>  Dispatched Orders:</td><td><select name=s1>");
		while(rs.next())
		{
		if(rs.getString(4).equals("ok"))
		{
                 
		out.println("<option>"+rs.getInt(1)+"</option>");
		out.println("</td></tr>");   
                out.println("</table>");
		out.println("<input type=submit name=sub value=ViewDetails>");

		       /* while(rs1.next())
		         {
			
			if(rs.getInt(1)==rs1.getInt(1))
			{		
				out.println("<tr><td>rs1.getInt(1)</td><td>rs1.getString(2)</td><td>rs1.getString(3)</td></tr>");
                                while(rs2.next())
                                {
                                 if(rs.getInt(1)==rs2.getInt(2))
                                  out.println("<tr><td>rs1.getInt(2)</td><td>rs1.getInt(3)</td><td></tr>");
                                }
                              rs2.beforeFirst();
			}
			rs1.beforeFirst();
		         }*/
		}//if
                 
	          }//while
                              
                }catch(Exception e){e.printStackTrace();}
           }
}	   