import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class DeleteItemController extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
   {
     resp.setContentType("text/html");
    PrintWriter out=resp.getWriter();
    out.println("<html><body bgcolor=lightyellow><h2><b><u>Delete Item from the warehouse</u></b></h2><center>");
    out.println("<form method=post action=./DeleteItemController2>");
    
        try
     {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select ITEMID from ITEM");
        out.println("<table><tr><td>Enter ItemId:</td><td><select name=s1>");
        while(rs.next())
         {
             out.println("<option name=op1>"+rs.getInt(1)+"</option>");
          }
       	out.println("</select></td></tr>");
	out.println("<tr><td align=middle><input type=submit name=sub value=delete></td></tr>");
	out.println("</table></form></body></html>");    
	}catch(Exception e){e.printStackTrace();}
}
}