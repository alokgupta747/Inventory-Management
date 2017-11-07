import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewCustomerStock extends HttpServlet
{
  public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
     try
     {
       HttpSession session=req.getSession();
       int qty=0,itemno=0,flag=0,rno=1;
       int customerid=Integer.parseInt(session.getAttribute("uid").toString());
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       out.println("<html><body bgcolor=lightyellow><center><u><b>Stock Details</b></u>");
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");

    //   Statement stmt1=con.createStatement();
       Statement stmt2=con.createStatement();
    //   Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    //   Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

       out.println("<table border=2 bordercolor=red>");
       out.println("<tr><th>ITEM</th><th>Quantity</th></tr>");

      // ResultSet rs=st.executeQuery("select * from  retailerpurchaseorder where retailerid="+retailerid);
    //   ResultSet rs3=stmt3.executeQuery("select * from retstock where retailerID="+retailerid);

     //  Statement stmt4=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
     //  ResultSet rs4=stmt4.executeQuery("select * from retstock where retailerID="+retailerid);

     /*  rs.beforeFirst();
       rs3.absolute(rno);
       while(rs.next())
       {
//         rs.absolute(rno);
         itemno=rs.getInt(3);
         System.out.println(itemno);
         qty=rs.getInt(4); 
         System.out.println(qty);
        while(rs3.next())
         {
           if(itemno==rs3.getInt(2))
           {
              qty=qty+rs3.getInt(3);
              System.out.println(qty);
              while(rs4.next())
              stmt1.executeUpdate("delete from retstock where itemno="+itemno);

              PreparedStatement pstmt=con.prepareStatement("INSERT INTO retstock VALUES(?,?,?)");                      
              pstmt.setInt(1,retailerid);
              pstmt.setInt(2,itemno);
              pstmt.setInt(3,qty);
              pstmt.executeUpdate();
          // }//if
         //}//while
         rno++;
         rs3.absolute(rno);
      }//while    */
       String rrr = "select b.itemname,a.qty from custstock a,item b where a.custid='"+customerid+"' and a.itemno=b.itemid";                  
	   System.out.println("RRR:"+rrr);
      ResultSet rs2=stmt2.executeQuery(rrr);
      while(rs2.next())
      {
         out.println("<tr><td>"+rs2.getString(1)+"</td>");
         out.println("<td>"+rs2.getInt(2)+"</td></tr>");
      }//while
      out.println("</table>");
      out.println("</center></body></html>");
   }//try
   catch(Exception e){e.printStackTrace();}
  }//service
}//class
