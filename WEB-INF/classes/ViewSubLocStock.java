import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewSubLocStock extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	    try
	         {
               
  	//HttpSession session=req.getSession();
	//int subinchargeid= Integer.parseInt(session.getAttribute("username").toString()); 
	int qty=0,it=0,flag=0,rno=1;
    HttpSession session = req.getSession();
	String un = (String)session.getAttribute("uid");
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<html><body bgcolor=lightyellow><center><u><b>Stock Details</b></u>");
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	Statement stmt1=con.createStatement();
	//Statement stmt2=con.createStatement();
	//Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	//Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

	out.println("<table border=2 bordercolor=red>");
	out.println("<tr><th>ITEM</th><th>Quantity</th></tr>");

//	ResultSet rs=st.executeQuery("select * from sublocationstock");    //where SLIID="+subinchargeid
          //       ResultSet rs3=stmt3.executeQuery("select * from sublocationstock where itemid=1");   // where SLIID="+subinchargeid

           //      Statement stmt4=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             //    ResultSet rs4=stmt4.executeQuery("select * from sublocationstock");                 // where ID="+subinchargeid
       /*          rs.beforeFirst();
                 rs3.absolute(rno);
                 while(rs.next())
                  {
                     rs.absolute(rno);
                     it=rs.getInt(1);
                    System.out.println(it);
                    qty=rs.getInt(2); 
                    System.out.println(qty);
                    while(rs3.next())
	    {
                          if(it==rs3.getInt(1))
                          {
                              qty=qty+rs3.getInt(2);
                              System.out.println(qty);
                              while(rs4.next())
     	                   stmt1.executeUpdate("delete from sublocationstock");

                  	 PreparedStatement pstmt=con.prepareStatement("INSERT INTO sublocationstock VALUES(?,?)");                      
   		 pstmt.setInt(1,it);
		 pstmt.setInt(2,qty);
		 pstmt.executeUpdate();
	       }//if
                   }//while
                rno++;
                rs3.absolute(rno);
              }//while    
                       */  
			String qyr = "select i.itemname,s.qty from SUBLOCATIONSTOCK s,item i where i.itemid=s.itemid and s.sublocid="+un;
			System.out.println("qyr:"+qyr);
			int i = 0;
                ResultSet rs2=stmt1.executeQuery(qyr); //SLIID="+subinchargeid);
                while(rs2.next())
                 {
					i++;
		out.println("<tr><td>"+rs2.getString(1)+"</td>");
		out.println("<td>"+rs2.getInt(2)+"</td></tr>");
	}//while
	if(i==0)
				 {
					out.println("<tr><td colspan=2>No Stock Available</td>");
				 }
		out.println("</table>");
		out.println("<a href=./blank.html>Home</a>");
		out.println("</center></body></html>");
             }//try
            catch(Exception e){e.printStackTrace();}
         }//service
}//main