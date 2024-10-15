package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {

	public AdminBean ab=null;

	public AdminBean Login(String un,String pw) {

		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from adminbook64 where uname=? and pword=?");

			ps.setString(1, un);
			ps.setString(2, pw);

			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				ab=new AdminBean();
				
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setmID(rs.getString(6));
				ab.setPhNo(rs.getLong(7));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ab;
	}

}
