<%@page import ="java.sql.*"%>
<%
Connection con = null;
   try
	{
		String id = request.getParameter("id");
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      con=DriverManager.getConnection("jdbc:odbc:insurance","system","tiger");
		 Statement stmt = con.createStatement();
		 Statement stmt1 = con.createStatement();
		 con.setAutoCommit(false);
%>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 		<%
	int i=stmt.executeUpdate("delete WAREHOUSEPURCHASEORDER where wpoid="+id+"");
	i+=stmt1.executeUpdate("delete warehousepayment where wpoid="+id+"");

	if(i==2)
	{
				 con.setAutoCommit(true);
	  out.println("<font color=red face=verdana size=3>Request Deleted Successfully");
	  response.setHeader("Refresh","2;URL=supp_po_req.jsp");
	}
%>
</table>
</body></html>
<%
	}catch(Exception e){
			 con.rollback();
			 e.printStackTrace();}
	%>
    