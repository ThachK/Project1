package com.revature.daos;

import com.revature.models.User;

public interface UserDAOInterface {
    // insert new user
    User insertUser(User user);

    //get user by user id
    User getUserById(int user);



}
