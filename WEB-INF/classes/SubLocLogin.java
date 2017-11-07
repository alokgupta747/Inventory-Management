import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class SubLocLogin extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,java.io.IOException
  {
       int flag=0;
        HttpSession session=req.getSession();
       
	try
	{
   	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
   	String username=req.getParameter("username");
   	String password=req.getParameter("password");
   	if((username.equals(""))||(password.equals("")))
  	{
     		out.println("Login & pwd should not be null");
     		resp.setHeader("Refresh","4;URL=./subloclogin.html");
   	}
	else
    	{
     		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");    		
                Statement stmt=con.createStatement();
                                    int username1=Integer.parseInt(username); 
   		ResultSet rs=stmt.executeQuery("select * from sublocationincharge where subinchargeid ="+username1);
    		if(rs.next())
                 {
 if((username.equals(rs.getString(1)))&&(password.equals(rs.getString(2))))
                  {
                    //(Object)username;

                 session.setAttribute("username",username);
                 session.setAttribute("pass",password);
    		getServletContext().getRequestDispatcher("/mainpage12.html").forward(req,resp);
    		   }
               flag=1;
              }//while

  	
                     if(flag==0)
                       {   
 		     	out.println("Authentication failed!! due to invalid login or pwd");    
		   	resp.setHeader("Refresh","4;URL=./subloclogin.html");
  	   	      }
                 }
	}catch(Exception e){e.printStackTrace();}
	}
}