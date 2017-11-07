import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SubLocPurchaseOrder extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
            int a=0,b=0,c=0,d=0,f=0,p=0,q=0,rno=1,it=0,qty=0;
      	try
	      {
                HttpSession session=req.getSession();
                int subinchargeid= Integer.parseInt(session.getAttribute("username").toString());
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body bgcolor=lightyellow><center><font color=red><b><u>SubLocation SalesOrder</b></u></font><br><br>");
			
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
                Statement stmt4=con.createStatement();
                Statement stmt5=con.createStatement();
                 Statement stmt6=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		Statement st11=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs11=st11.executeQuery("select * from sublocationstock where SLIID="+subinchargeid);
                ResultSet rs6=stmt6.executeQuery("select * from sublocationstock where SLIID="+subinchargeid);
                Statement stmt7=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs7=stmt7.executeQuery("select * from sublocationstock where SLIID="+subinchargeid);
                rs11.beforeFirst();
                rs6.absolute(rno);
                while(rs11.next())
                  {
                    rs11.absolute(rno);
                 it=rs11.getInt(2);
                  System.out.println(it);
                 qty=rs11.getInt(3); 
                  System.out.println(qty);
                 while(rs6.next())
		  {
                     if(it==rs6.getInt(2))
                    {
                   qty=qty+rs6.getInt(3);
                    System.out.println(qty);
                    while(rs7.next())
                    stmt4.executeUpdate("delete from sublocationstock where itemid="+it);
                   PreparedStatement pstmt1=con.prepareStatement("INSERT INTO sublocationstock VALUES(?,?,?)");                      

         pstmt1.setInt(1,subinchargeid);
         pstmt1.setInt(2,it);
         pstmt1.setInt(3,qty);
         pstmt1.executeUpdate();
                  }//if
                 }//while
                rno++;
               rs6.absolute(rno);
              }//while    
                
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs2=st2.executeQuery("select * from sublocationstock where sliid="+subinchargeid);
		ResultSet rs=st.executeQuery("select * from sublocationstock where sliid="+subinchargeid);
                	
		Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                Statement st3=con.createStatement();
		ResultSet rs1=st1.executeQuery("select * from retailerpurchaseorder where sliid="+subinchargeid);
		
		System.out.println("slpo");
		//int p=0,q=0;
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
                  d=rs.getInt(2);
                  f=rs.getInt(3);
          
		 System.out.println("hai");
		if((a==d)&&(b<=f))
		{
                       System.out.println("hello");
			    f=f-b;
                            while(rs2.next())
                            st.executeUpdate("update sublocation set QTY="+f+"WHERE  ITEMID="+d);                                       
                        PreparedStatement pstmt=con.prepareStatement("insert into slsalesorder values(?,?,?,?,?)");
			System.out.println("before s");
                         		 pstmt.setInt(1,c);
                          		pstmt.setString(2,"");
                          		pstmt.setString(3,"");
                                        pstmt.setInt(4,a);
                                        pstmt.setInt(5,b); 
                                        pstmt.executeUpdate();
                        st3.executeUpdate("delete from slpurchaseorder WHERE RPOID="+c);          
                        // rs=st.executeQuery("select * from warehousestock");
                }
                   
         
  	System.out.println("p"+p);
                p++;
            System.out.println(rs);
              }//in while
		rs.beforeFirst();
		q++;
		System.out.println("q"+q);
	}//out while	
                                out.println("<li><a href=./WHPendingOrder2>view pending orders</a></li><br>");
                                out.println("<li><a href=./WHDispatchOrder2>view Dispatched orders</a></li><br>");
		out.println("<li><a href=mainpage11.html>Home</a></li>");
		out.println("</form></center></body></html>");	
	      }catch(Exception e){e.printStackTrace();}
	}//service
}
