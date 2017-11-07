import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class SubLocsignout extends HttpServlet
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
   out.println("You Are Successfully Logout");   
   out.println("<br>");
   out.println("<br>");   
  // out.println("<a href='./Signin.html' target='new'>Do u want to Signin again</a>");  
   out.println("</body></html>"); 
  }//service
}//class 

