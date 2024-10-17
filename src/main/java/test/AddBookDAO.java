package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddBookDAO {

	public int k=0;
	
	public  int AddBook(BookBean b) {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into book64 values(?,?,?,?,?)");
				
			ps.setString(1, b.getCode());
			ps.setString(2, b.getName());
			ps.setString(3, b.getAuthor());
			ps.setFloat(4, b.getPrice());
			ps.setInt(5,b.getQty());
			
			k=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}	
		return k;
	}
}
