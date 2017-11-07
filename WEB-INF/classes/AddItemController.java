import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddItemController extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
				
		String name=req.getParameter("Name");
                System.out.println(name);
		double unitcost=Double.parseDouble(req.getParameter("ItemCost"));
		System.out.println(unitcost);
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			Statement stmt=con.createStatement();
			int ITEMID=0;
			ResultSet rs=stmt.executeQuery("select max(ITEMID) from item");
			if(rs.next())
			{
				ITEMID=rs.getInt(1);
				ITEMID++;
				System.out.println("id"+ITEMID);
			}
			else
			{
				ITEMID=1;
			}
			 PreparedStatement pstmt=con.prepareStatement("insert into item values(?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,ITEMID);
			pstmt.setString(2,name);
			pstmt.setDouble(3,unitcost);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				out.println("Item "+name+" Added Successfully");
				resp.setHeader("Refresh","2;URL=./AddItem.jsp");
								
				}
			else
			{
				out.println("Failed to Add Item "+name+"");
				resp.setHeader("Refresh","2;URL=./AddItem.jsp");
			}
			
			rs.close();
			pstmt.close();
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
	