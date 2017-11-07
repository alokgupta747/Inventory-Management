import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddWareHouseStock extends HttpServlet
{
     public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
        {
          try
	{
                                res.setContentType("text/html");
	                PrintWriter out=res.getWriter();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from ITEM");		
		out.println("<html><bgcolor=lightyellow><center><b><u>WareHouse Stock</u></b><br><br>");
		out.println("<form action=./AddWareHouseStock1 method=post>");
		out.println("<table>");
		out.println("<tr><td>  Item Id:</td><td><select name=s1>");
		while(rs.next())
		{
		out.println("<option>"+rs.getInt(1)+"</option>");
		}
                out.println("</select></td></tr>");
                        rs.beforeFirst();

                         out.println("<tr><td>ItemName:</td><td><select name=s3>");
                         
			   while(rs.next())
			{
                        out.println("<option value="+rs.getString(1)+">"+rs.getString(2)+"</option>");
			}
                        out.println("</select></td></tr>");
			out.println("</select></td></tr>");

		out.println("</td></tr>");
		out.println("<tr><td>Quantity:</td><td><input type=text name=qty></td></tr>");
		out.println("</table>");
		out.println("<input type=submit name=sub value=AddStock>");
		out.println("</form></center></body></html>");
                    }catch(Exception e){e.printStackTrace();}
	}
}
		
		
						   	