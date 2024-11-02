package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userLoginDAO {

	public UserBean ub=null;
	
	public UserBean userLogin(String un,String pw) {
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userbook64 where uname=? and pword=?");
			
			ps.setString(1, un);
			ps.setString(2, pw);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo((rs.getLong(7)));
				
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return ub;
	}
	
}
