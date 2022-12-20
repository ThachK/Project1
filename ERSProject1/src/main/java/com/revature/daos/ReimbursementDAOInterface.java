package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAOInterface {

    //view previous ticket reimbursement submissions
    //select all from reimbursements where user-id ...
    ArrayList<Reimbursement> getReimbursementsById(int user_id);

    //create dao methods to get foreign keys



}
