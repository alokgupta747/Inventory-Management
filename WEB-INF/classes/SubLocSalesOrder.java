import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SubLocSalesOrder extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
    int a=0,b=0,c=0,d=0,f=0,p=0,q=0,rno=1,it=0,qty=0;
    try{
      HttpSession session=req.getSession(true);
      int subinchargeid=Integer.parseInt((String)session.getAttribute("username"));               
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>SubLocation SalesOrder</b></u></font><br><br>");
			
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
      Statement stmt4 = con.createStatement();
	  stmt4.executeUpdate("delete from sublocationstock where itemid="+it);
      PreparedStatement pstmt1=con.prepareStatement("INSERT INTO sublocationstock VALUES(?,?)");                      

      pstmt1.setInt(1,it);
      pstmt1.setInt(2,qty);
      pstmt1.executeUpdate();
            
      Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=st.executeQuery("select * from sublocationstock");   // where sliid="+subinchargeid
      Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      ResultSet rs1=st1.executeQuery("select * from retailerpurchaseorder");
      Statement st3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

System.out.println("slpo");
      rs1.beforeFirst();
      while(rs1.next())
      {
System.out.println("s");
        rs.beforeFirst();
        c=rs1.getInt(2);
        a=rs1.getInt(3);
        b=rs1.getInt(4);
System.out.println("before inner while");
        while(rs.next())
        {
          d=rs.getInt(1);
          f=rs.getInt(2); 
System.out.println("hai");
          if((a==d)&&(b<=f))
          {
System.out.println("hello");
             f=f-b;
             st3.executeUpdate("update sublocationstock set QTY="+f+"WHERE  ITEMID="+d);                                       
             PreparedStatement pstmt=con.prepareStatement("insert into slsalesorder values(?,?,?,?,?,?)");
System.out.println("before s");
             pstmt.setInt(1,c);
             pstmt.setInt(2,subinchargeid);
             pstmt.setString(3,"");
             pstmt.setString(4,"");
             pstmt.setInt(5,a);
             pstmt.setInt(6,b); 
             pstmt.executeUpdate();
             st3.executeUpdate("delete from retailerpurchaseorder WHERE RPOID="+c);          
             // rs=st.executeQuery("select * from warehousestock");
           }//if
System.out.println("p"+p);
           p++;
System.out.println(rs);
         }//in while
         rs.beforeFirst();
         q++;
System.out.println("q"+q);
      }//out while 
      out.println("<li><a href=./SLPendingOrder>view pending orders</a></li><br>");
      out.println("<li><a href=./SLDispatchOrder2>view Dispatched orders</a></li><br>");
      out.println("<li><a href=blank.html>Home</a></li>");
      out.println("</form></center></body></html>"); 
    }//try
    catch(Exception e){e.printStackTrace();
  }//service
}//class
}