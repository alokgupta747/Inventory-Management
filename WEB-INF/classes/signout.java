import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class signout extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
   HttpSession session=req.getSession();
   PrintWriter out= res.getWriter();
   session.removeAttribute("username");
   session.removeAttribute("emailid");   

   out.println("<html><body>");
   out.println("<br>");
   out.println("<br>");
   out.println("<center>");
   out.println("TankYou for using WareHouse...............");   
   out.println("<br>");
   out.println("<br>");   
   out.println("<a href='./home.html'>Do u want to Signin again</a>");  
   out.println("</body></html>"); 
  }//service
}//class 

