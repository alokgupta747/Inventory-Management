<%@page import ="java.sql.*"%>
<%
   try
	{
		String a = request.getParameter("sdate");
		String c = request.getParameter("s3");
		String d = request.getParameter("Wqty");
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
		 Statement check = con.createStatement();
		 
		 
			int WPOID=0;
	     ResultSet rs=st.executeQuery("select max(PID) from SL_PURCHASE1");
		 if(rs.next())
			{
				
				WPOID=rs.getInt(1);
				WPOID++;
			}
			else
			{
				WPOID=1;
			}
			System.out.println("idssssssss"+WPOID);
			Statement  stmtt=con.createStatement();
			String insqry = "insert into SL_PURCHASE1 values("+WPOID+",'"+a+"','"+c+"','"+d+"','"+uid+"')";
			System.out.println("ins qry:"+insqry);
			int up = stmtt.executeUpdate(insqry);
			System.out.println("after update");
			if(up==1)
		{
			out.println("Purchase order Sent to Administrator with Order Id:"+WPOID);
		     response.setHeader("Refresh","2;URL=./subloc_purchase.jsp");

		}
		
		else
		{
				out.println("Sorry! Unable to process to your request!! Please Try Again!!!");
		     response.setHeader("Refresh","2;URL=./subloc_purchase.jsp");

		}
	}catch(Exception e){e.printStackTrace();}
	%>
    