package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartBooksBuyDAO {

    public int buyBooks(AddCartBean acb) {
        int result = 0;
        try  {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE book64 SET bqty = bqty - ? WHERE bcode = ?");
            ps.setInt(1, acb.getNoOfBooks()); 
            ps.setString(2, acb.getCode().trim());  
            result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Successfully updated: " + result + " rows.");
            } else {
                System.out.println("No rows updated for book code: " +acb.getCode());
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        catch (Exception e) {
            e.printStackTrace(); 
        }
        return result; 
    }
}
