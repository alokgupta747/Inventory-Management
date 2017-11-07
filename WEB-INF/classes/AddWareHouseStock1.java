import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddWareHouseStock1 extends HttpServlet
    {
   	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 	{
	      
	      try
		{
		int i=0,j=0,flag=0;
                                 
		int itemno=Integer.parseInt(req.getParameter("s1"));
		int qty1=Integer.parseInt(req.getParameter("qty").trim());
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String qry= "update warehousestock set qty=qty+"+qty1+" where ITEMID="+itemno;
		System.out.println("add stock query:"+qry);
		int k=st.executeUpdate(qry);  
		if(k==1)
		{	
			out.println("<font face=verdana color=red size=3>"+qty1+" Items Updated Successfully");
			res.setHeader("Refresh","2;URL=./AddStock.jsp");
		}
		else
		{
			PreparedStatement pstmt=con.prepareStatement("insert into warehousestock values(?,?)");
			System.out.println(qty1+" Items Added Successfully");
			pstmt.setInt(1,itemno);
			pstmt.setInt(2,qty1);
		                 i=pstmt.executeUpdate();
			
			out.println("<font face=verdana color=red size=3>"+qty1+" Items Added Successfully");
			res.setHeader("Refresh","2;URL=./AddStock.jsp");
			
			
		
		}
					
		}catch(Exception e){e.printStackTrace();}
	}
}
			