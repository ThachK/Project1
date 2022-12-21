package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAOInterface {

    //view previous ticket reimbursement submissions
    //select all from reimbursements where user-id ...
    ArrayList<Reimbursement> getReimbursementsById(int user_id);

    //method to change the reimbursement status
    boolean updateReimbursementStatusById(int rId, int statusId);

    //method to view only pending reimbursements
    ArrayList<Reimbursement> getPendingReimbursements(int statusId);

    //method to submit new reimbursements
    Reimbursement insertReimbursement(Reimbursement reimbursement);



}
