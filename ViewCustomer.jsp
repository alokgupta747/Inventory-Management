<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
		 String ww = "select * from whcustomer where RETAILERID="+uid;
		 System.out.println("WW:"+ww);
	     ResultSet rs=st.executeQuery(ww);
	  %>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 <tr>
	 <th><span class="style8">Customer Name</span></th>
	 <th><span class="style8">Phone</span></th>
	 <th><span class="style8">E-mail</span></th>
	 <th><span class="style8">House</span></th>
	 <th><span class="style8">Street</span></th>
	 <th><span class="style8">City</span></th>
	 <th><span class="style8">Country</span></th>
	 <th><span class="style8">E Mail</span></th>
	 <th><span class="style8">Delete</span></th>
	 </tr>
	 <%
	  
	while(rs.next())
	     {
			int id = rs.getInt(1);
		%>
		<tr>
			<td><span class="style13"><%=rs.getString(3)%></span></td>
			<td><span class="style13"><%=rs.getString(4)%></span></td>
			<td><span class="style13"><%=rs.getString(5)%></span></td>
			<td><span class="style13"><%=rs.getString(6)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(8)%></span></td>
			<td><span class="style13"><%=rs.getString(9)%></span></td>
			<td><span class="style13"><%=rs.getString(10)%></span></td>

			<td><span class="style13"><a href="DeleteCustomer.jsp?id=<%=id%>">Delete</a></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    