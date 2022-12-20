package com.revature.daos;

import com.revature.models.User;

import java.util.ArrayList;

public interface UsersDAOInterface {

    //view previous ticket reimbursement submissions
    //select all from reimbursements where user-id ...
    ArrayList<User> getReimbursementsById();

}
