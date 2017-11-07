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
<form action="./Supplier" method="post" name="sform">
<center>
<table>
<tr><td align=right><span class="style10">Password            :</span></td>
<td><input type="text" name =pass></td></tr>
<tr><td align=right><span class="style10">Name            :</span></td>
<td><input type="text" name =Name></td></tr>
<tr><td align=right><span class="style10">Phone           :</span></td>
<td><input type="text" name =Phone ></td></tr>
<tr><td align=right><span class="style10">E-mail           :</span></td>
<td><input type="text" name =Email ></td></tr>
<tr><td align=right><span class="style10">House no      :</span></td>
<td><input type="text" name =House  ></td></tr>
<tr><td align= right><span class="style10">Street           :</span></td>
<td><input type="text" name =Street ></td></tr>
<tr><td align= right><span class="style10">City             :</span></td>
<td><input type="text" name =City ></td></tr>
<tr><td align= right><span class="style10">Country       : </span></td>
<td><input type="text" name =Country ></td></tr>
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

