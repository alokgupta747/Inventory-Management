import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WHDispatchOrder2 extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
            int a=0,b=0,c=0,d=0,f=0,p=0,q=0;
      	try
	      {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>WareHouse DispatchOrders</b></u></font><br><br>");
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement();
               // Statement st2=con.createStatement();
		ResultSet rs=st.executeQuery("select wso.slpoid,slp.podate,slp.cheno,wso.itemid,wso.qty from warehousesalesorder wso,slpayment slp where wso.slpoid=slp.subpoid");
                	
		//Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                //Statement st3=con.createStatement();
		//ResultSet rs1=st1.executeQuery("select * from slpayment");
		
		//System.out.println("slpo");
		//int p=0,q=0;
		//rs1.beforeFirst();
                out.println("<html><body bgcolor=lightyellow><table border=2>");
        	out.println("<tr><th>SLPOID</th><th>SLPAYEMENTDATE</th><th>CHEQUE/DDNO</th><th>ITEMID</th><th>QTY</th></tr>");	     
  
		while(rs.next())
		{
		    
		
		// a=rs.getInt(1);
                 //b=rs1.getInt(3);
                // System.out.println("before inner while");
	//	while(rs.next())
	//	{
                  //b=rs1.getInt(1);
                          
		 System.out.println("hai");
		//if(a==b)
		//{

                    //  out.println("<tr><td>"+b+"</td>");
                      out.println("<td>"+rs.getInt(1)+"</td>");
                      out.println("<td>"+rs.getString(2)+"</td>");
                      out.println("<td>"+rs.getString(3)+"</td>");
                      out.println("<td>"+rs.getString(4)+"</td>");
                      out.println("<td>"+rs.getString(5)+"</td></tr>");  
                   
                // }//if
                   
         
  
              //  p++;
               // System.out.println(rs);
              //}//in while
                //rs1.beforeFirst();
		//q++;
		//System.out.println("q"+q);
        	}//out while
               // rs.beforeFirst();
                //rs1.beforeFirst();
              /*  out.println("<form action=./WHDispatchOrder3 method=post>");	
                out.println("<center>");
                out.println("<h3>DISPATCH THE ORDER</h3>");
                out.println("<table>");
                out.println("<tr><td>Enter ORDERNO:</td><td><select name=s1>");
                while(rs.next())
		{
		    
		System.out.println("s");
		 a=rs.getInt(1);
                 //b=rs1.getInt(3);
                 System.out.println("before inner while");
		while(rs1.next())
		{
                  b=rs1.getInt(1);
                          
		 System.out.println("hai");
		if(a==b)
		{

                out.println("<option name=op1>"+b+"</option>");
                }
               }//inwhile
               rs1.beforeFirst();
              }//outwhile 
       	       out.println("</select></td></tr>");
                out.println("<tr><td align=right>WAREHOUSE SALES DATE:</td><td><input type=text name =WAREHOUSESALESDATE></td></tr>");
                out.println("<tr><td align=right>SHIPEMENT DES:</td><td><input type=text name =SHIPEMENTDES></td></tr>");
                      */

                out.println("</table>");
                out.println("</center>");
               // out.println("</form>");
                //out.println("<tr><td align=middle><input type=submit name=sub value=DISPATCH></td></tr>");
		out.println("<li><a href=blank.html>Home</a></li>");
		out.println("</form></center></body></html>");	
	      }catch(Exception e){e.printStackTrace();}
	}//service
}
