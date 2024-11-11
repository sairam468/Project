package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDAO {

	int k=0;
	public int UpdateBook(BookBean bb) {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update book64 set bprice=?,bqty=? where bcode=?");
			ps.setFloat(1, bb.getPrice());
			ps.setInt(2, bb.getQty());
			ps.setString(3,bb.getCode());
			k=ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		
		return k;
	}
}
