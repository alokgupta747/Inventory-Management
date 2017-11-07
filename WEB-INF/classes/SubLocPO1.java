import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SubLocPO1 extends HttpServlet
{
  	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
  	{
	try
	{
          
	resp.setContentType("text/html");
	HttpSession session = req.getSession();
	PrintWriter out=resp.getWriter();
	String un = (String)session.getAttribute("username");
	String podate=req.getParameter("SubLocdate");
	String cheno=req.getParameter("SubLoccheque");
	int itemno=Integer.parseInt(req.getParameter("s2"));
	int qty=Integer.parseInt(req.getParameter("SubLocqty"));
		
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	Statement stmt=con.createStatement();	
                int flag=0; 	
	int SUBPOID=0;
			
		
			ResultSet rs=stmt.executeQuery("select max(SUBPOID) from slpayment");
			if(rs.next())
			{
				
				SUBPOID=rs.getInt(1);
				SUBPOID++;
				
				
			}
			else
			{
				SUBPOID=1;
			}
			
	if((podate.equals(null))&&(cheno.equals(null))&&(qty==0))
	{
    	out.println("filds should not null");
    	resp.setHeader("Refresh","2;URL=./SubLocPO");
	}
	else	
	{    
	flag=1;	
	PreparedStatement pstmt=con.prepareStatement("insert into slpurchaseorder values(?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,SUBPOID);
			System.out.println("id");
			pstmt.setInt(2,itemno);
			System.out.println("no");
			pstmt.setInt(3,qty);
			System.out.println("qty");
			pstmt.executeUpdate();
			Statement s1 = con.createStatement();
			String q = "select qty from sublocationstock where itemid="+itemno;
			System.out.println("q qry:"+q);
			ResultSet rs1 = s1.executeQuery(q);
			int available = 0 ;
			if(rs1.next())
		{
				System.out.println("stock having");
				available = rs1.getInt(1);
				int total = available + qty;
				Statement ss = con.createStatement();
		String qrry = "update SUBLOCATIONSTOCK set qty="+total+" where itemid="+itemno;
		System.out.println("qrry:"+qrry);
		ss.executeUpdate(qrry);
		}
		else
		{
							System.out.println("stock not having");
			Statement ss1  = con.createStatement();
			String qq1 = "insert into sublocationstock values("+itemno+","+qty+",'"+un+"')";
			System.out.println("qq1 qry:"+qq1);
			int x = ss1.executeUpdate(qq1);
		}
			
	PreparedStatement pstmt1=con.prepareStatement("insert into slpayment values(?,?,?,?)");
		System.out.println("pstmt1");
		pstmt1.setInt(1,SUBPOID);
		System.out.println("id1");
             
		pstmt1.setString(2,podate);
		System.out.println("date"+podate);
		pstmt1.setString(3,cheno);
		System.out.println("cno");
		pstmt1.setInt(4,Integer.parseInt(un));
		System.out.println("un:"+un);

		pstmt1.executeUpdate();
		             
		}
		if(flag==1)
		{
                                     out.println("Purchase order"+SUBPOID);
		     resp.setHeader("Refresh","2;URL=./blank.html");
		}
				
	}catch(Exception e){e.printStackTrace();}	
			               
		
         }
}	