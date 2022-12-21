package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
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
                // update objects
                int userfk = resultSet.getInt("user_id_fk");
                int rtypefk = resultSet.getInt("reimbursement_type_id_fk");
                int rstatusfk = resultSet.getInt("reimbursement_status_id_fk");

                UserDAO uDAO = new UserDAO();
                User u = uDAO.getUserById(userfk);

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                ReimbursementStatus rs = rsDAO.getReimbursementStatusById(rstatusfk);

                ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
                ReimbursementType rt = rtDAO.getReimbursementTypeById(rtypefk);

                reimbursement.setUser(u);
                reimbursement.setRt(rt);
                reimbursement.setRs(rs);

                reimbursementList.add(reimbursement);


            }
            return reimbursementList;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }

    @Override
    public boolean updateReimbursementStatusById(int rId, int statusId) {
        try (Connection conn = ConnectionUtils.getConnection()) {
            String sql = "UPDATE reimbursements " +
                    "SET reimbursement_status_id_fk = ? " +
                    "WHERE reimbursement_id = ? ;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusId);
            ps.setInt(2, rId);

            ps.executeUpdate(); // execute query is only for selects

            return true;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return false;
    }

    @Override
    public ArrayList<Reimbursement> getPendingReimbursements(int statusId) {
        try (Connection conn = ConnectionUtils.getConnection()){
            String sql = "SELECT * FROM reimbursements WHERE reimbursement_status_id_fk  = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusId);

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
                int userfk = resultSet.getInt("user_id_fk");
                int rtypefk = resultSet.getInt("reimbursement_type_id_fk");
                int rstatusfk = resultSet.getInt("reimbursement_status_id_fk");

                UserDAO uDAO = new UserDAO();
                User u = uDAO.getUserById(userfk);

                ReimbursementStatusDAO rsDAO = new ReimbursementStatusDAO();
                ReimbursementStatus rs = rsDAO.getReimbursementStatusById(rstatusfk);

                ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
                ReimbursementType rt = rtDAO.getReimbursementTypeById(rtypefk);

                reimbursement.setUser(u);
                reimbursement.setRt(rt);
                reimbursement.setRs(rs);

                reimbursementList.add(reimbursement);


            }
            return reimbursementList;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }

    @Override
    public Reimbursement insertReimbursement(Reimbursement reimbursement) {

        try (Connection conn = ConnectionUtils.getConnection()) {
            String sql = "INSERT INTO reimbursements(reimbursement_amount,reimbursement_description, user_id_fk, reimbursement_type_id_fk, reimbursement_status_id_fk) " +
                    "VALUES (?, ?, ?, ?, ?); ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getReimbursement_amount());
            ps.setString(2, reimbursement.getReimbursement_description());
            ps.setObject(3, reimbursement.getUser());
            ps.setObject(4, reimbursement.getRt());
            ps.setObject(5, reimbursement.getRs());

            ps.executeUpdate(); // execute query is only for selects

            return reimbursement;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
