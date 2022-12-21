package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtils;
import io.javalin.Javalin;

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

        Javalin app = Javalin.create(
                //This config lambda lets us specify certain configurations for our Javalin object
                // ->? "For this config object, do the following things"
                config -> {
                    config.enableCorsForAllOrigins(); //This lets us process HTTP Requests from anywhere
                    //CORS - cross-origin resource sharing

                }
        ).start(4000);

        ReimbursementController rc = new ReimbursementController();
        AuthController ac = new AuthController();

        /*
        // create an instance of our reimbursementDAO
        ReimbursementDAO remDao = new ReimbursementDAO();

        //update status to 2 by id 2
        //TODO: need to authorize for managers only
        //remDao.updateReimbursementStatusById(2, 2);

        // call the get...ById -> see what we're getting
        //ArrayList<Reimbursement> reimbursements = remDao.getReimbursementsById(3);
        //ArrayList<Reimbursement> reimbursements = remDao.getReimbursementsByStatus(1);
        //ArrayList<Reimbursement> reimbursements = remDao.getReimbursementsById(3);

        for(Reimbursement rs : reimbursements){
            System.out.println(rs);
        }
        /*
        UserDAO userDAO = new UserDAO();
        User hamza = new User("Hamza", "Kamran", "hamza", "password", 1);

        userDAO.insertUser(hamza);*/

        app.post("/login", ac.loginHandler);
        app.post("/register", ac.registerHandler);
        app.post("/reimbursements", rc.insertReimbursementHandler);
        app.patch("/reimbursements/{reimbursementId}/{reimbursementStatusId}", rc.updateUserReimbursementByStatusHandler);

        app.post("/status-pending", rc.getUserReimbursementByStatusHandler);
        app.get("/login/view-reimbursements", rc.getReimbursementsByIdHandler);
    }
}
