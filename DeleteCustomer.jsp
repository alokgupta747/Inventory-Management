<%@page import ="java.sql.*"%>
<%
   try
	{
		String id = request.getParameter("id");
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		 Statement stmt = con.createStatement();
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
	int i=stmt.executeUpdate("delete whcustomer where CUSTOMERID="+id+"");

	if(i==1)
	{
	  out.println("<font color=red face=verdana size=3>Customer Deleted Successfully");
	  response.setHeader("Refresh","2;URL=ViewCustomer.jsp");
	}
%>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    