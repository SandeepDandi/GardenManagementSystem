package ssdi;
import java.sql.*;
public class dcc {
	public static Connection getconnection()
	{
		Connection connection= null;
        String url="dbc:oracle:thin:@localhost:1521:xe";
        String username="system";
        String password="qwe123";
        String driver="oracle.jdbc.driver.OracleDriver";
        try
        {
        Class.forName(driver);
        connection=DriverManager.getConnection(url, username, password);
        System.out.println("Connection:"+connection);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return connection;
	}
	public static void main(String args[])
	{
		Connection con=dcc.getconnection();
		if(con!=null)
		{
			System.out.println("Connection Established!");
		}
		else
		{
		System.out.println("Connection Failed!");	
		}
	}

}
