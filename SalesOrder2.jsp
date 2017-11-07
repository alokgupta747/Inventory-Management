<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from whcustomer");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style21 {font-family: verdana; font-size: 12px; }
-->
      </style>
	  <body >
	  <form name=f1 action="./salesorderprocess2.jsp">
	  <table border=2>
	  <center>
	  <div align="center"><b>Retailer Sales Order</b><br>
        <br>
      </div>
	  <table align="center">
<tr><td><span class="style21">Sales OrderDate:(dd/mm/yyyy)<font color=red>*</font></span></td>
<td><input type=text name=sdate></td></tr>
	<tr><td><span class="style21">Customer:</span></td>
	<td><select name=s1>
		<%
			while(rs.next())
			{
				%><option value="<%=rs.getInt(1)%>"><%=rs.getString(3)%></option>
			<%}%>
		</select></td></tr>
<%		Statement stmt2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2=stmt2.executeQuery("select * from ITEM");
			 rs2.beforeFirst();
%>         <tr><td><span class="style21">ItemName:</span></td>
<td><select name=s3>
              <%           
			   while(rs2.next())
			{
                  %>
						<option value="<%=rs2.getString(1)%>"><%=rs2.getString(2)%></option>");
				  <%
			}
            %></select></td></tr>
			<tr><td><span class="style21">Quantity:<font color=red>*</font></span></td>
			<td><input type=text name=Wqty></td></tr>
			<tr><td colspan=2>&nbsp;</td>
			</tr>
			<tr><td align=middle colspan=2><div align="center">
			  <input name=sub type=submit value="Add Sales Order">
			  </div></td>
			</tr>
</table>
</body></html>
<%
	}catch(Exception e){e.printStackTrace();}
	%>
    