import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WHPendingOrder2 extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
            int a=0,b=0,c=0,d=0,f=0,p=0,q=0;
      	try
	      {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse PendingOrder</b></u></font><br><br>");
			
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement();
               
ResultSet rs=st.executeQuery("select spo.subpoid,slp.podate,slp.cheno from slpurchaseorder spo,slpayment slp where spo.subpoid=slp.subpoid");	
		//Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                
		//ResultSet rs1=st1.executeQuery("select * from slpayment");
		
		System.out.println("slpo");
		
		//rs1.beforeFirst();
                out.println("<html><body bgcolor=lightyellow><table border=2>");
        	out.println("<tr><th>SLPOID</th><th>SLPAYEMENTDATE</th><th>CHEQUE/DDNO</th></tr>");	     
  
		while(rs.next())
		{
		    
		/*System.out.println("s");
		 a=rs.getInt(1);
	               	System.out.println("before inner while");
		while(rs1.next())
		{
                            	b=rs1.getInt(1);
                   	 System.out.println("hai");
		if(a==b)
		{
	                 out.println("<tr><td>"+b+"</td>");*/

                      out.println("<td>"+rs.getInt(1)+"</td>");
                      out.println("<td>"+rs.getString(2)+"</td>");
                      out.println("<td>"+rs.getString(3)+"</td></tr>");
                   
                // }//if
                   
         
  	/*     
                p++;
                System.out.println(rs);
              }//in while
		rs1.beforeFirst();
		q++;
		System.out.println("q"+q);*/

        	}//out while
                out.println("</table>");
		out.println("<li><a href=blank.html>Home</a></li>");
		out.println("</form></center></body></html>");	
	      }catch(Exception e){e.printStackTrace();}
	}//service
}
