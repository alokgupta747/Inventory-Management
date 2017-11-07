import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddSubLocRetailer extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("uid");
		PrintWriter out=resp.getWriter();
		String cpass=req.getParameter("Cpassword");
   		String name=req.getParameter("Name");
		String house=req.getParameter("House");
		String street=req.getParameter("Street");
		String city=req.getParameter("City");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		String phone=req.getParameter("Phone");
		String email=req.getParameter("Email");
		
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			
			Statement stmt=con.createStatement();
			int RETAILERID=0;
			ResultSet rs=stmt.executeQuery("select max(RETAILERID) from retailer");
			System.out.println("rs");
			if(rs.next())
			{
				RETAILERID=rs.getInt(1);
				RETAILERID++;
				
				System.out.println("id"+RETAILERID);
			}
			else
			{
				RETAILERID=1;
			}
			con.setAutoCommit(false);
			 PreparedStatement pstmt=con.prepareStatement("insert into retailer values(?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
            			//pstmt.setInt(1,subinchargeid);                       

			pstmt.setInt(1,RETAILERID);
			
			pstmt.setString(2,cpass);
			
			pstmt.setString(3,name);

			pstmt.setString(4,house);
			
			pstmt.setString(5,street);
			
			pstmt.setString(6,city);
			
			pstmt.setString(7,state);
			
			pstmt.setString(8,country);
			
			pstmt.setString(9,phone);
			
			pstmt.setString(10,email);

			pstmt.setString(11,uid);
			
			int i=pstmt.executeUpdate();
			System.out.println("record inserted");
			Statement st = con.createStatement();
			String qryy = "insert into whm_login values('"+RETAILERID+"','"+cpass+"','3')";
			System.out.println("Qryy:"+qryy);
			i+=st.executeUpdate(qryy);
			if(i==2)
			{
				out.println("<font face=verdana color=red size=3>Retailer for Sublocation Added Successfully</font>");
				resp.setHeader("Refresh","2;URL=./AddRetailer.jsp");
								con.setAutoCommit(true);
			
				}
			else
			{
				out.println("<font face=verdana color=red size=3>Failed to Add</font>");
				resp.setHeader("Refresh","2;URL=./AddRetailer.jsp");
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
	