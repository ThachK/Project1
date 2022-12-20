package com.revature;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtils.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL!");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("CONNECTION FAILED ;C");
        }

        // create an instance of our reimbursementDAO
        ReimbursementDAO remDao = new ReimbursementDAO();

        // call the get...ById -> see what we're getting
        ArrayList<Reimbursement> reimbursements = remDao.getReimbursementsById(3);

        for(Reimbursement rs : reimbursements){
            System.out.println(rs);
        }

    }
}
