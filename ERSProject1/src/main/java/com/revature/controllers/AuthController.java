package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {
    AuthDAO aDAO = new AuthDAO();

    public static HttpSession ses;
    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();

        Gson gson = new Gson();

        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);

        User loggedInUser = aDAO.login(lDTO.getUsername(), lDTO.getUser_password());

        if (loggedInUser != null) {

            ses = ctx.req.getSession();
            //turn the employee back into JSON, so we can send it in the HTTP request

            ses.setAttribute("userID", loggedInUser.getUser_id());
            ses.setAttribute("roleID", loggedInUser.getUser_role_id_fk());

            String userJSON = gson.toJson(loggedInUser);
            ctx.result(userJSON);
            ctx.status(202); //202 "accepted"
        } else {
            ctx.status(401); //401 "unauthorized"
        }
    };
        public Handler registerHandler = (ctx) -> {
            String body = ctx.body();

            Gson gson = new Gson();

            User newUser = gson.fromJson(body, User.class);

            if (aDAO.register(newUser.getFirst_name(), newUser.getLast_name(), newUser.getUsername(), newUser.getUser_password(), newUser.getUser_role_id_fk())!= null){

                ctx.result(gson.toJson(newUser));
                ctx.status(202); //202 "accepted"
            } else {
                ctx.status(401); //401 "unauthorized"
                ctx.result("Username already exists, please try again.");
            }
        };

}
