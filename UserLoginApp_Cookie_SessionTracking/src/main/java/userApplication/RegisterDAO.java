package userApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    public int insertUserDetails(UserBean ub) {
        int k = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("insert into userapp64 values (?,?,?,?,?,?,?)")) {

            if (ub == null) {
                throw new NullPointerException("UserBean is null");
            }

            ps.setString(1, ub.getName());
            ps.setString(2, ub.getPword());
            ps.setString(3, ub.getFname());
            ps.setString(4, ub.getLname());
            ps.setString(5, ub.getAddr());
            ps.setString(6, ub.getMid());
            ps.setLong(7, ub.getPnum());

            k = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting user details: " + e.getMessage());
        }
        return k;
    }
}

