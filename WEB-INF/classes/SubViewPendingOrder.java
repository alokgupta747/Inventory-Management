import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SubViewPendingOrder extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
            int a=0,b=0,c=0,d=0,f=0,p=0,q=0;
      	try
	      {
                HttpSession session=req.getSession();
                int subinchargeid=Integer.parseInt(session.getAttribute("username").toString());
                res.setContentType("text/html");
                PrintWriter out=res.getWriter();
               out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse PendingOrder</b></u></font><br><br>");
			
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                       Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement();
               // Statement st2=con.createStatement();
		ResultSet rs=st.executeQuery("select * from slpurchaseorder");
                	
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                //Statement st3=con.createStatement();
		ResultSet rs1=st1.executeQuery("select * from slpayment");
		// WHERE SLIID="+subinchargeid
		
		System.out.println("slpo");
		rs1.beforeFirst();
                out.println("<html><body bgcolor=lightyellow><table border=2>");
        	out.println("<tr><th>SLPOID</th><th>SLIID</th><th>SLPAYEMENTDATE</th><th>CHEQUE/DDNO</th></tr>");	     
  
		while(rs.next())
		{
		    
		System.out.println("s");
		 a=rs.getInt(1);
                 //b=rs1.getInt(3);
                 System.out.println("before inner while"+a);
		while(rs1.next())
		{
                  b=rs1.getInt(1);
                          
		 System.out.println("hai"+b);
		if(a==b)
		{

                      out.println("<tr><td>"+b+"</td>");
                      out.println("<td>"+subinchargeid+"</td>");
                      out.println("<td>"+rs1.getString(2)+"</td>");
                      out.println("<td>"+rs1.getString(3)+"</td></tr>");
                   
                 }//if
                   
         
  	        System.out.println("p"+p);
                p++;
                System.out.println(rs);
               b=0;
              }//in while
		rs1.beforeFirst();
		q++;
		System.out.println("q"+q);
        	}//out while
                out.println("</table>");
		out.println("<li><a href=blank.html>Home</a></li>");
		out.println("</form></center></body></html>");	
	      }catch(Exception e){e.printStackTrace();}
	}//service
}
