<%@page import ="java.sql.*"%>
<%
   try
	{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from ITEM order by itemid");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style13 {font-family: tahoma; font-size: 12px; }
.style25 {font-family: verdana; font-size: 14px; }
-->
      </style>
	  <body bgcolor=lightyellow><table border=2>
	 <tr>
		<th><span class="style25">ItemNo</span></th>
		<th><span class="style25">ItemName</span></th>
		<th><span class="style25">UnitCost</span></th>
		<th><span class="style25">Select</span></th>
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
			<td><span class="style13"><a href="DeleteItem.jsp?id=<%=id%>">Delete</a></span></td>
		</tr>
		<%
			
	}
             %>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    