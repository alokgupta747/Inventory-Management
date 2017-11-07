<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select a.*,b.itemname,c.name from WAREHOUSERETSALESORDER a,item b,whcustomer c where a.itemid=b.itemid and a.customerID=c.customerID");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body><table border=2>
	 <tr><th><span class="style8">Sales Id</span></th>
	 <th><span class="style8">Saled Date</span></th>
	 <th><span class="style8">Retailer Name</span></th>
	 <th><span class="style8">Item Name</span></th>
	 <th><span class="style8">Quantity</span></th>
	 </tr>

	 <%
	  
	while(rs.next())
	     {
	%>
		<tr>
			<td><span class="style13"><%=rs.getString(1)%></span></td>
			<td><span class="style13"><%=rs.getString(2)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(6)%></span></td>
			<td><span class="style13"><%=rs.getString(5)%></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    