<%@page import ="java.sql.*"%>
<%
   try
	{
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from retailer");
	  %>
	  <html>
	  <style type="text/css">
<!--
.style21 {font-family: verdana; font-size: 12px; }
-->
      </style>
	  <body >
	  <form name=f1 action="./custsalesorderprocess.jsp">
	  <table border=2>
	  <center>
	  <div align="center"><b>Purchase Order</b><br>
        <br>
      </div>
	  <table align="center">
<tr><td><span class="style21">Purchase OrderDate:(dd/mm/yyyy)<font color=red>*</font></span></td>
<td><input type=text name=sdate></td></tr>
	
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
			
<%		Statement stmt22=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs22=stmt22.executeQuery("select * from retailer");
			 rs22.beforeFirst();
%>         <tr><td><span class="style21">Retailer Name:</span></td>
<td><select name=s3>
              <%           
			   while(rs22.next())
			{
                  %>
						<option value="<%=rs22.getString(1)%>"><%=rs22.getString(3)%></option>");
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
    