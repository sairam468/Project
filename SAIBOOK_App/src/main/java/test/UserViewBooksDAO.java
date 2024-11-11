package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserViewBooksDAO {

	public ArrayList<BookBean> al=new ArrayList<BookBean>();
	public ArrayList<BookBean> viewBooks() {
		
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book64");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookBean bb=new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));
				al.add(bb);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return al;
	}
}
