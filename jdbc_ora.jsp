
<%@page import ="java.sql.*"%>
<%!private int count=0;
 Connection con=null;
 Statement st=null;
 ResultSet rs=null;
 String usr,passwd;
 %>

 <%
  usr=request.getParameter("name"); 
  System.out.println("usr value:"+usr);
  passwd=request.getParameter("pass");
  String utype = request.getParameter("utype");%>
  
  <%
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
 st=con.createStatement();
 %>
 <%
String qry = "select  *  from whm_login where user_id='"+usr+"' and login_pwd='"+passwd+"' and user_type='"+utype+"'";
System.out.println("Login Query:"+qry);
rs=st.executeQuery(qry);
 %>
 <%
if(rs.next())
{        
	 session.setAttribute( "uid",usr);
	 if(utype.equals("1"))
	 response.sendRedirect("admin_logged.jsp");
	 else 	 if(utype.equals("2"))
	 response.sendRedirect("sli_logged.jsp");
	 else 	 if(utype.equals("3"))
	 response.sendRedirect("retailer_logged.jsp");
	 else 	 if(utype.equals("4"))
	 response.sendRedirect("supplier_logged.jsp");
	 else 	 if(utype.equals("5"))
	 response.sendRedirect("customer_logged.jsp");
} 
else 
	{
		%>
	   <script  language="javaScript">
	     window.alert("invalid user:");
    	</script>
        
		<body>
		</body>
		
	<jsp:include page="login.html"/>
    <%
		}

}
catch(Exception e)
{
out.println(e);
}
finally
{
	if(st!=null)st.close();
	if(con!=null)con.close();
}
%>
	