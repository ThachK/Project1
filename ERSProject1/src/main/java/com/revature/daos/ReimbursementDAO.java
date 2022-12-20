package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;

public class ReimbursementDAO implements ReimbursementDAOInterface{
    @Override
    public ArrayList<Reimbursement> getReimbursementsById(int user_id) {
        try (Connection conn = ConnectionUtils.getConnection()){
            String sql = "SELECT * FROM reimbursements WHERE user_id_fk = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, user_id);

            ResultSet resultSet = ps.executeQuery();

            ArrayList<Reimbursement> reimbursementList = new ArrayList();
            while (resultSet.next()){
                Reimbursement reimbursement = new Reimbursement(
                    resultSet.getInt("reimbursement_id"),
                        resultSet.getInt("reimbursement_amount"),
                        resultSet.getString("reimbursement_description"),
                        null,
                        null,
                        null
                );
                // update the user object
                //reimbursement.setUser(user);
                // update the reimbursement type object
                // update the reimbursement status object
                reimbursementList.add(reimbursement);


            }
            return reimbursementList;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
