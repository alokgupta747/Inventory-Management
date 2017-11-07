import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class  CustomerChPwd1 extends HttpServlet
{ 
	 
	public void  service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
	int i=0;String a=" ",sc;
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	
	try
	{    
	HttpSession session = req.getSession();
    String c=((String)(session.getAttribute("uid"))).trim();
   	   String d=req.getParameter("pass");
 	   String f=req.getParameter("cpass");
	   if (c==null||d==null||f==null)
	      {
    		     pw.println("<h3> field should not be null><br>");
	      }
		  		  else if(!d.equals(f))
		{
			pw.println("<h3>New Password & Confirm Password Should Be Same<br>");
		    res.setHeader("Refresh","2;URL=./SubLocChPwd");	
		}

	    else 
	      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
			Statement st=con.createStatement();
			String qry = "update whm_login set login_pwd='"+f+"' where user_id='"+c+"'  and user_type='5'";
			System.out.println("qry:"+qry);
			i=st.executeUpdate(qry);
  	      }
		   
	
 	if (i==1)
  		{
  		     pw.println ("your password is changed");
			res.setHeader("Refresh","2;URL=./RetailerChPwd");
		}
		else
		{
			pw.println("Password has not changed<br>Try toAdd Again!!");
			res.setHeader("Refresh","URL=./RetailerChPwd");
		}
	}catch(Exception e){e.printStackTrace();}		 
			   	
        }
}