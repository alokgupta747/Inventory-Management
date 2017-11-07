<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
		 String qq = "select a.*,b.NAME,c.ITEMNAME from SL_PURCHASE1 a,SUBLOCATIONINCHARGE b,item c where a.SLOCID=b.SUBINCHARGEID and a.itemid=c.itemid and a.SLOCID="+uid;
		 System.out.println("QQ:"+qq);
	     ResultSet rs=st.executeQuery(qq);
	  %>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body><table border=2>
	 <tr><th><span class="style8">Purchase Id</span></th>
	 <th><span class="style8">Purchased Date</span></th>
	 <th><span class="style8">Item Name</span></th>
	 <th><span class="style8">Quantity:</span></th>
	 </tr>

	 <%
	  
	while(rs.next())
	     {
	%>
		<tr>
			<td><span class="style13"><%=rs.getString(1)%></span></td>
			<td><span class="style13"><%=rs.getString(2)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(4)%></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    