package com.revature.models;

public class UserRole {
    private int user_role_id;
    private String user_role_title;

    public UserRole() {
    }

    public UserRole(int user_role_id, String user_role_title) {
        this.user_role_id = user_role_id;
        this.user_role_title = user_role_title;
    }

    public UserRole(String user_role_title) {
        this.user_role_title = user_role_title;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_role_title() {
        return user_role_title;
    }

    public void setUser_role_title(String user_role_title) {
        this.user_role_title = user_role_title;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "user_role_id=" + user_role_id +
                ", user_role_title='" + user_role_title + '\'' +
                '}';
    }
}
