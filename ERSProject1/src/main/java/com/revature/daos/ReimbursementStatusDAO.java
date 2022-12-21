package com.revature.daos;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementStatusDAO implements ReimbursementStatusDAOInterface {

    //get reimbursement status by id
    @Override
    public ReimbursementStatus getReimbursementStatusById(int rStatusId) {
        try(Connection conn = ConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM reimbursement_status WHERE reimbursement_status_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rStatusId); //the first wildcard will be equal to the id variable

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReimbursementStatus reimbursementStatus = new ReimbursementStatus(
                        rs.getInt("reimbursement_status_id"),
                        rs.getString("reimbursement_status")
                );

                // Constructor opened up to show cleaner code?

                return reimbursementStatus; //return role data to user
            }
        }
        catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
