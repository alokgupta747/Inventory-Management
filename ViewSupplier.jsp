<%@page import ="java.sql.*"%>
<%
   try
	{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from supplier");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style8 {font-size: 14px; font-family: verdana;}
.style13 {font-family: tahoma; font-size: 12px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 <tr><th><span class="style8">SupNo</span></th>
	 <th><span class="style8">SupName</span></th>
	 <th><span class="style8">Phone</span></th>
	 <th><span class="style8">E-mail</span></th>
	 <th><span class="style8">House</span></th>
	 <th><span class="style8">Street</span></th>
	 <th><span class="style8">City</span></th>
	 <th><span class="style8">Country</span></th>
	 <th><span class="style8">Delete</span></th>
	 </tr>
	 <%
	  
	while(rs.next())
	     {
			int id = rs.getInt(1);
		%>
		<tr>
			<td><span class="style13"><%=id%></span></td>
			<td><span class="style13"><%=rs.getString(2)%></span></td>
			<td><span class="style13"><%=rs.getString(3)%></span></td>
			<td><span class="style13"><%=rs.getString(4)%></span></td>
			<td><span class="style13"><%=rs.getString(5)%></span></td>
			<td><span class="style13"><%=rs.getString(6)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(8)%></span></td>
			<td><span class="style13"><a href="DeleteSupplier.jsp?id=<%=id%>">Delete</a></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    