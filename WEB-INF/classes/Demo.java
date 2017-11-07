import java.sql.*;
import java.io.*;
public class Demo
{
 public static void main(String rags[])throws SQLException,IOException
  {
	 try
	  {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:insurance","smart","smart");
	Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs3=stmt3.executeQuery("select * from sublocationstock where SLIID="+1);
         while(rs3.next())
          {
           System.out.println(rs3.getInt(1));
          }
	  }
	  catch(Exception e)
	  {

	  }
   }
}