import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SubLocationController extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
    		String pass=req.getParameter("password");
		System.out.println(pass);
		String name=req.getParameter("Name");
		String house=req.getParameter("House");
		String street=req.getParameter("Street");
		String city=req.getParameter("City");
		String phone=req.getParameter("Phone");
                System.out.println(phone);
		String email=req.getParameter("Email");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		String location=req.getParameter("Location");
		int maxretailers=Integer.parseInt(req.getParameter("MaxnoOfRetailers"));
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			Statement stmt=con.createStatement();
			int SUBINCHARGEID=0;
			ResultSet rs=stmt.executeQuery("select max(SUBINCHARGEID) from sublocationincharge");
			if(rs.next())
			{
				SUBINCHARGEID=rs.getInt(1);
				SUBINCHARGEID++;
				System.out.println("id"+SUBINCHARGEID);
			}
			else
			{
				SUBINCHARGEID=1;
			}
			con.setAutoCommit(false);
			PreparedStatement pstmt=con.prepareStatement("insert into sublocationincharge values(?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUBINCHARGEID);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
			pstmt.setString(4,house);
			pstmt.setString(5,street);
			pstmt.setString(6,city);			
			pstmt.setString(7,phone);
			pstmt.setString(8,email);
			pstmt.setString(9,state);
			pstmt.setString(10,location);
			pstmt.setInt(11,maxretailers);
			pstmt.setString(12,country);
			int i=pstmt.executeUpdate();
			Statement st = con.createStatement();
			String qryy = "insert into whm_login values('"+SUBINCHARGEID+"','"+pass+"','2')";
			System.out.println("Qryy:"+qryy);
			i+=st.executeUpdate(qryy);
			if(i==2)
			{
				out.println("<font face=verdana color=red size=3>Incharge for Sublocation Added Successfully</font>");
				resp.setHeader("Refresh","2;URL=./AddSubLocationIncharge.jsp");
							con.setAutoCommit(true);
								
				}
			else
			{
				out.println("<font face=verdana color=red size=3>Incharge for Sublocation Added Failed</font>");
				resp.setHeader("Refresh","2;URL=./AddSubLocationIncharge.jsp");
			}
			
			rs.close();
			pstmt.close();
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
							out.println("<font face=verdana color=red size=3>Incharge for Sublocation Added Failed</font>");
				resp.setHeader("Refresh","2;URL=./AddSubLocationIncharge.jsp");

		}
	}
}
	