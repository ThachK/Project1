package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import io.javalin.http.Handler;

import java.util.ArrayList;


public class ReimbursementController {

    ReimbursementDAO reimbursementDAO  = new ReimbursementDAO();

    public Handler getUserReimbursementByStatusHandler = (ctx) -> {
        if(AuthController.ses != null) {

            int roleID = (Integer)AuthController.ses.getAttribute("roleID");

            if (roleID == 1){

                //only for pending
                ArrayList<Reimbursement> reimbursements = reimbursementDAO.getPendingReimbursements(1);

                Gson gson = new Gson();

                String JSONUsers = gson.toJson(reimbursements);

                ctx.result(JSONUsers);

                ctx.status(202);
            } else{
                ctx.result("You must be a Manager to view pending reimbursements. Get a promotion, loser");
                ctx.status(401); //unauthorized
            }



        } else { //if the user is NOT logged in:
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }
    };

    public Handler updateUserReimbursementByStatusHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("roleID");
            if (roleID == 1) {
                String reimbursementId = ctx.pathParam("reimbursementId");

                String reimbursementStatusId = ctx.pathParam("reimbursementStatusId");

                if (reimbursementDAO.updateReimbursementStatusById(Integer.parseInt(reimbursementId), Integer.parseInt(reimbursementStatusId))) {
                    ctx.result("Update executed");
                    ctx.status(202);
                }
            } else {
                ctx.result("You must be a Manager to view pending reimbursements. Get a promotion, loser");
                ctx.status(401); //unauthorized
            }
        } else { //if the user is NOT logged in:
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }
    };
    public Handler insertReimbursementHandler = (ctx) -> {
            String body = ctx.body();
            Gson gson = new Gson();

            Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);

            if (reimbursementDAO.insertReimbursement(reimbursement) != null){
                ctx.status(202);
                ctx.result(body);
            } else{
                ctx.status(401); //unauthorized
                ctx.result("Insert reimbursement failed. Reimbursement Amounts and " +
                        "Descriptions are required, please try again.");
            }
    };


}
