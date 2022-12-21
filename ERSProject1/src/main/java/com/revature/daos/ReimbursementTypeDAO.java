package com.revature.daos;

import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementTypeDAO implements ReimbursementTypeDAOInterface {
    @Override
    public ReimbursementType getReimbursementTypeById(int rTypeId) {
        try(Connection conn = ConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM reimbursement_type WHERE reimbursement_type_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rTypeId); //the first wildcard will be equal to the id variable

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReimbursementType reimbursementType = new ReimbursementType(
                        rs.getInt("reimbursement_type_id"),
                        rs.getString("reimbursement_type")
                );

                // Constructor opened up to show cleaner code?

                return reimbursementType; //return role data to user
            }
        }
        catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
