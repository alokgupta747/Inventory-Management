import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RetailerBill extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
		
   		resp.setContentType("text/html");
                                 HttpSession session=req.getSession(true);
		PrintWriter out=resp.getWriter();
		Statement stmt=null;
		Statement stmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		System.out.println("hello");	
		String retid=(String)session.getAttribute("username");
                                   String rpoid=null;
                                 double cost=0.0;
                                 double billamt=0.0;
                                 int qty=0;
                        System.out.println("retid:"+retid);
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		System.out.println("con");
		 stmt=con.createStatement();
		 stmt1=con.createStatement();
 rs=stmt.executeQuery(" select rp.rpoid,rp.podate,rp.cheno,rpo.itemno,rpo.qty from retailerpayment rp,retailerpurchaseorder rpo where rp.rpoid=rpo.rpoid  and rpo.retailerid='"+retid+"' ");

out .println("<b><U>RETAILER BILL DETAILS</U></b>");
out.println("<br><br><br>");
out.println("RETAILERID:   "+retid);
out.println("<table border=2 colspan=2 rowspan=2><tr><th>RPOID</th><th>PODATE</th><th>CHENO</th><th>ITEMNO</th><th>QTY</th><th>PRICE</th></tr>");

	
	   while(rs.next())
	    {
                       rpoid=rs.getString(1);
	 System.out.println("rpoid:"+rpoid);
	 rs1=stmt1.executeQuery("select unitcost from item where itemid='"+rpoid+"' ");
                   if(rs1.next())
                 cost=Double.parseDouble(rs1.getString(1));
                  System.out.println("cost:"+cost);
	out.println("<tr><td>"+rpoid+"</td>");
	out.println("<td>"+rs.getString(2)+"</td>");
	out.println("<td>"+rs.getString(3)+"</td>");
	out.println("<td>"+rs.getString(4)+"</td>");
                 qty=Integer.parseInt(rs.getString(5));
	out.println("<td>"+qty+"</td>");
	out.println("<td>"+cost+"</td></tr>");
                    billamt+=qty*cost;
	    }//while
                      out.println("</table>");
	out.println("<hr>");
                 out.println("BILLAMT:   "+billamt);
	out.println("<hr>");
	}//try
                  catch(Exception e){e.printStackTrace();}
         }//service
}//class