package userApplication;
import java.sql.*;
import jakarta.servlet.http.HttpServletRequest;
public class LoginDAO {
	public UserBean ub=null;
	
	public UserBean login(HttpServletRequest req) {
		
		try {
			Connection con =DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userapp64 where name=? and password=?");
			
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				ub=new UserBean();
				ub.setName(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPnum(rs.getLong(7));
		
			}
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		return ub;
	}

}
