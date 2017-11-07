<%@page import ="java.sql.*"%>

<%String msg = "";
if(request.getAttribute("msg")!=null && !request.getAttribute("msg").equals(""))
{
	msg = (String)request.getAttribute("msg");
}%>
<html>
<script language="javascript">
</script>
<style type="text/css">
<!--
.style10 {font-family: Verdana; font-size: 12px; }
-->
</style>
<body>
<center><h1>Supplier Details </h1></center>
<form action="./AddWareHouseStock1" method="post" name="sform">
<center>
<%
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from ITEM");		
%>
<table>
<tr><td align=right><span class="style10">Name            :</span></td>
<td><select name="s1">
<%while(rs.next())
{
	%>
<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
<%}%>
</select></td></tr>
<tr><td>Quantity:</td><td><input type=text name=qty></td></tr>
<tr><td align=center colspan="2"><p class="style10">&nbsp;
  </p>
    <p class="style10">
      <input type="submit" name ="submit"  value="Add Supplier">
    </p></td></tr>
</table>
</center>
</form>
<p>
<font face = verdana color=red size=2><%=msg%></font>
</body>
</html>

