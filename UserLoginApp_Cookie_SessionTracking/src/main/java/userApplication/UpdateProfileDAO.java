package userApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {
int k=0;
public int update(UserBean ub) {
	try {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("update userapp64 set address=?,mailid=?,phnumber=? where name=? and password=?");
		ps.setString(1,ub.getAddr());
		ps.setString(2, ub.getMid());
		ps.setLong(3,ub.getPnum());
		ps.setString(4, ub.getName());
		ps.setString(5, ub.getPword());
		
		k=ps.executeUpdate();
			}
	catch(Exception e) {e.printStackTrace();}
	
	
	return k;
}
	
}
