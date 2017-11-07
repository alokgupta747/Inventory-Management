<%@page import ="java.sql.*"%>
<%
   try
	{
		String a = request.getParameter("sdate");
		String b = request.getParameter("s1");
		String c = request.getParameter("s3");
		String d = request.getParameter("Wqty");
		String uid = (String)session.getAttribute("uid");
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	     Statement st=con.createStatement();
		 Statement check = con.createStatement();
		 con.setAutoCommit(false);
		 String yy = "select * from RETSTOCK where itemNO='"+c+"' and RETAILERID="+uid;
		 System.out.println("YY:"+yy);
		 ResultSet checkrs = check.executeQuery(yy);
		 int stock = 0;
		 if(checkrs.next())
		{
			stock=checkrs.getInt(3);
		}
		int req = Integer.parseInt(d);
		System.out.println("req:"+req);
		System.out.println("req:"+a);
		System.out.println("stock:"+stock);
		if(stock >= req)
		{

	 	int WPOID=0;
	     ResultSet rs=st.executeQuery("select max(SLPOID) from WAREHOUSERETSALESORDER");
		 if(rs.next())
			{
				
				WPOID=rs.getInt(1);
				WPOID++;
			}
			else
			{
				WPOID=1;
			}
			System.out.println("id"+WPOID);
			PreparedStatement pstmt=con.prepareStatement("insert into WAREHOUSERETSALESORDER values(?,?,?,?,?)");
			System.out.println("pstmt");
			pstmt.setInt(1,WPOID);
			pstmt.setString(2,a);
			pstmt.setString(3,b);
			pstmt.setString(4,c);
			pstmt.setString(5,d);
			int up = pstmt.executeUpdate();
			Statement upst = con.createStatement();
			String upqry = "update RETSTOCK set qty = qty-"+Integer.parseInt(d)+" where itemno='"+c+"' and RETAILERID='"+uid+"'";
			System.out.println("upqry:"+upqry);
			up+=upst.executeUpdate(upqry);

			Statement checkst1 = con.createStatement();
			String ss="select * from CUSTSTOCK where itemno='"+c+"' and CUSTID='"+b+"'";
			System.out.println("SS:"+ss);
			ResultSet rss = checkst1.executeQuery(ss);
			boolean flag1=false;
			if(rss.next())
			{
				flag1 = true;
			}
			if(flag1)
			{
				Statement upst1 = con.createStatement();
				String upqry1 = "update CUSTSTOCK set qty = qty+"+Integer.parseInt(d)+" where itemno='"+c+"' and CUSTID='"+b+"'";
				System.out.println("upqry1:"+upqry1);
				up+=upst1.executeUpdate(upqry1);
			}
			else
			{
				Statement upst1 = con.createStatement();
				String upqry1 = "insert into CUSTSTOCK values('"+b+"','"+c+"','"+Integer.parseInt(d)+"')";
				System.out.println("upqry1:"+upqry1);
				up+=upst1.executeUpdate(upqry1);

			}
			System.out.println("UP:"+up);
			con.setAutoCommit(true);
			if(up==3)
		{
			out.println("Sales order with Order Id:"+WPOID);
		     response.setHeader("Refresh","2;URL=./SalesOrder2.jsp");

		}
		}
		else
		{
				out.println("Stock Not Available! Available Stock is:"+stock);
		     response.setHeader("Refresh","2;URL=./SalesOrder2.jsp");

		}
	}catch(Exception e){e.printStackTrace();}
	%>
    