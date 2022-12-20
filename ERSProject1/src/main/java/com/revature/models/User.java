package com.revature.models;

public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String user_password;
    private int user_role_id_fk;

    public User() {
    }

    public User(int user_id, String first_name, String last_name, String username, String user_password, int user_role_id_fk) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.user_password = user_password;
        this.user_role_id_fk = user_role_id_fk;
    }

    public User(String first_name, String last_name, String username, String user_password, int user_role_id_fk) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.user_password = user_password;
        this.user_role_id_fk = user_role_id_fk;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_role_id_fk() {
        return user_role_id_fk;
    }

    public void setUser_role_id_fk(int user_role_id_fk) {
        this.user_role_id_fk = user_role_id_fk;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_role_id_fk=" + user_role_id_fk +
                '}';
    }
}