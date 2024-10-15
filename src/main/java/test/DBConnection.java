package test;
import java.sql.*;
public class DBConnection {
	private static Connection con=null;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection(IDBInfo.DB_URL,IDBInfo.U_NAME,IDBInfo.PASSWORD);
		}
		catch(Exception e)
		{e.printStackTrace();}
		
	}
	
	public static Connection getConnection() {
		return con;
	}

}
