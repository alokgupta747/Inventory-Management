import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SupController extends HttpServlet
{
  	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
   		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//String id=req.getParameter("s1");
		String pass = req.getParameter("pass");
    		String name=req.getParameter("Name");
		System.out.println(name);
		String phone = req.getParameter("Phone");
                                System.out.println(phone);
		String email=req.getParameter("Email");
		System.out.println(email);
		String house=req.getParameter("House");
		System.out.println(house);
		String street=req.getParameter("Street");
		System.out.println(street);
		String city=req.getParameter("City");
		System.out.println(city);
		String country=req.getParameter("Country");
		try
		{
			
			        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			//new oracle.jdbc.driver.OracleDriver();
			  //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@active:1521:active","scott","tiger");
			System.out.println("con");
			Statement stmt=con.createStatement();
			int SUPPLIERID=0;
			ResultSet rs=stmt.executeQuery("select max(SUPPLIERID) from supplier");
			System.out.println("rs");
			if(rs.next())
			{
				SUPPLIERID=rs.getInt(1);
				SUPPLIERID++;
				//out.println("<html><body><form action='./AddSupplier.html'><select name=s1><option name=op1>"+rs.getString(s1)+"</option></select>");
				//out.println("</form></body></html>");			
				System.out.println("id"+SUPPLIERID);
			}
			else
			{
				SUPPLIERID=1;
			}
			 PreparedStatement pstmt=con.prepareStatement("insert into supplier values(?,?,?,?,?,?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUPPLIERID);
			pstmt.setString(2,name);
			pstmt.setString(3,phone);
			pstmt.setString(4,email);
			pstmt.setString(5,house);
			pstmt.setString(6,street);
			pstmt.setString(7,city);
			pstmt.setString(8,country);
			int i=pstmt.executeUpdate();
			Statement st = con.createStatement();
			String qryy = "insert into whm_login values('"+SUPPLIERID+"','"+pass+"','4')";
			System.out.println("Qryy:"+qryy);
			i+=st.executeUpdate(qryy);
			if(i==2)
			{
				out.println("<font face=verdana color=red size=3>Supplier Added Successfully</font>");
				resp.setHeader("Refresh","2;URL=./AddSupplier.jsp");
								
				}
			else
			{
				out.println("<font face=verdana color=red size=3>Supplier Added Failed</font>");
				resp.setHeader("Refresh","2;URL=./AddSupplier.jsp");
			}
			
			rs.close();
			pstmt.close();
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
							out.println("<font face=verdana color=red size=3>Supplier Added Failed</font>");
				resp.setHeader("Refresh","2;URL=./AddSupplier.jsp");

		}
	}
}
	