import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  AdminChPwd1 extends HttpServlet
{ 
	 
	public void  service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
	int i=0;String a=" ",sc;
	HttpSession session = req.getSession();
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	try
	{    
           String c=((String)(session.getAttribute("uid"))).trim();
   	   String d=req.getParameter("pass");
 	   String f=req.getParameter("cpass");
	   if (c==null||d==null||f==null)
	      {
    		     pw.println("<h3> field should not be null<br>");
	      }
		  else if(!d.equals(f))
		{
				pw.println("<h3>New & Confirm Password Should Not Match<br>");
		}
		else
	      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			Statement st=con.createStatement();
			String qry = "update whm_login set login_pwd='"+f+"' where user_id='"+c+"'  and user_type='1'";
			System.out.println("qry:"+qry);
			i=st.executeUpdate(qry);
  	      }
		   
	
 	if (i==1)
  		{
  	             	pw.println ("<font face=verdana color=red size=2>Password Changed Successfully");
			res.setHeader("Refresh","2;URL=./blank.html");
		}
		else
		{
			pw.println("Password has not changed<br>Try toAdd Again!!");
			res.setHeader("Refresh","URL=./AdminChPwd");
		}
	}catch(Exception e){e.printStackTrace();}		 
			   	
        }
}