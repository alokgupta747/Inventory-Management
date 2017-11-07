<%@page import ="java.sql.*"%>
<%
   try
	{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from sublocationincharge");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style13 {font-family: tahoma; font-size: 12px; }
.style20 {font-family: verdana; font-size: 14px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 <tr>
<tr><th><span class="style20">SubIncId</span></th>
<th><span class="style20">SubName</span></th>
<th><span class="style20">HNo</span></th>
<th><span class="style20">Street</span></th>
<th><span class="style20">City</span></th>
<th><span class="style20">PhNo</span></th>
<th><span class="style20">E-mail</span></th>
<th><span class="style20">State</span></th>
<th><span class="style20">Location</span></th>
<th><span class="style20">MaxNoRet</span></th>
<th><span class="style20">Country</span></th>
<th><span class="style20">Select</span></th>
</tr>
	 
	 <%
	  
	while(rs.next())
	     {
			int id = rs.getInt(1);
		%>
		<tr>
			<td><span class="style13"><%=id%></span></td>
			<td><span class="style13"><%=rs.getString(3)%></span></td>
			<td><span class="style13"><%=rs.getString(4)%></span></td>
			<td><span class="style13"><%=rs.getString(5)%></span></td>
			<td><span class="style13"><%=rs.getString(6)%></span></td>
			<td><span class="style13"><%=rs.getString(7)%></span></td>
			<td><span class="style13"><%=rs.getString(8)%></span></td>
			<td><span class="style13"><%=rs.getString(9)%></span></td>
			<td><span class="style13"><%=rs.getString(10)%></span></td>
			<td><span class="style13"><%=rs.getString(11)%></span></td>
			<td><span class="style13"><%=rs.getString(12)%></span></td>
			<td><span class="style13"><a href="DeleteSubloc.jsp?id=<%=id%>">Delete</a></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    