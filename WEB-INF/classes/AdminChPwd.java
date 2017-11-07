import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AdminChPwd extends HttpServlet
{
 //String c,a;
  public void service(HttpServletRequest req,HttpServletResponse res)
     throws IOException,ServletException
{
	try
	{
  	//a=(req.getParameter("var")).trim();
  	res.setContentType("text/html");
   	PrintWriter pw=res.getWriter();
   	pw.println("<html><body bgcolor =lightyellow><center><u>");
   	pw.println("<font color=red> Admin Password Change</font></u></center>");
   	pw.println("<form METHOD=POST ACTION=./AdminChPwd1>");
   	pw.println("<br><br>");
   	pw.println("<table align=center>");
   	pw.println("<tr><td> New PassWord               :</td><td><input type=password NAME=pass SIZE=30></td></tr> ");
   	pw.println("<tr><td> Conformation PassWord  :</td><td><input type=password NAME=cpass SIZE=30></td></tr> ");
  	pw.println("<tr><td>&nbsp;</td></tr>");
  	pw.println("<tr><td>&nbsp;</td></tr>");
   	pw.println("<tr><td><input type=SUBMIT NAME=SUBMIT VALUE=SUBMIT SIZE=10>" );
   	pw.println("</td><td><input type=RESET NAME=RESET SIZE=20></td></tr> ");
   	pw.println("</table>");		
   	pw.println("</form></BODY></HTML|>");
   	pw.close();
 	
 	
	}catch(Exception e){e.printStackTrace();}									
    }
}
