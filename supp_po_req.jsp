<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
		 String q = "select a.WPOID,a.PAYDATE,a.SUPPLIERID,a.CHEQUENO,b.name,c.qty,d.itemname from warehousepayment a,supplier b,WAREHOUSEPURCHASEORDER c,item d where a.supplierid=b.supplierid and a.wpoid=c.wpoid and c.itemid=d.itemid and a.supplierid="+uid;
		 System.out.println(q);
	     ResultSet rs=st.executeQuery(q);
	  %>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 <tr><th><span class="style8">Requested Date</span></th>
	 <th><span class="style8">Item</span></th>
	 <th><span class="style8">Quantity</span></th>
	 <th><span class="style8">Cheque No</span></th>
	 <th><span class="style8">Delete</span></th>
	 </tr>
	 <%
	  
	while(rs.next())
	     {
			int id = rs.getInt(1);
		%>
		<tr>
			<td><span class="style13"><%=rs.getString(2)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(6)%></span></td>
			<td><span class="style13"><%=rs.getString(4)%></span></td>
			<td><span class="style13"><a href="DeleteAdminReqOrder.jsp?id=<%=id%>">Delete</a></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    