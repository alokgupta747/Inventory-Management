import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WHPendingOrder1 extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
      	try
	      {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse PendingOrder</b></u></font>");
		out.println("<form>");
		
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs1=st1.executeQuery("select * from warehousestock");
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from sublocationpayment");
		
		Statement st2=con.createStatement();
		ResultSet rs2=st2.executeQuery("select * from slpurchaseorder");
		
		System.out.println("slpo");
		out.println("<table><tr><th>PurchaseOrder</th><th>PaymentDate</th><th>CheckNo</th></tr>");
		int p=0,q=0;
		while(rs2.next())
		{
		int b=rs2.getInt(2);
		while(rs1.next())
		{
		int a=rs1.getInt(1);
		if(a==b)
		{
			if(rs1.getInt(2)<rs2.getInt(3))
			{
                          while(rs.next())
                           {
                            int c=rs.getInt(1);
                            if(b==c)
                             { 
			     out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
			     }
                           rs.first();
                          }

                       }   
		}
                rs1.first();
		q++;
		System.out.println(q);
		}
		System.out.println(p);
		p++;
		}

		

		out.println("<a href=mainpage11.html>Home</a>");
		out.println("</form></center></body></html>");	
	      }	catch(Exception e){e.printStackTrace();}
	}
}