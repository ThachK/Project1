package com.revature.daos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements UserDAOInterface{

    @Override
    public User insertUser(User user) {
        try (Connection conn = ConnectionUtils.getConnection()) {
            String sql = "INSERT INTO users(first_name, last_name, username, user_password, user_role_id_fk) " +
                    "VALUES (? , ?, ?, ?, ?); ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getUser_password());
            ps.setInt(5, user.getUser_role_id_fk());

            ps.executeUpdate(); // execute query is only for selects

            return user;
        } catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }

    @Override
    public User getUserById(int user) {

        try(Connection conn = ConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM users WHERE user_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, user); //the first wildcard will be equal to the id variable

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("user_password"),
                        rs.getInt("user_role_id_fk")
                );

                // Constructor opened up to show cleaner code?

                return u; //return role data to user
            }
        }
        catch(SQLException e){
            e.printStackTrace(); //if something goes wrong this will display and error message
        }
        return null;
    }
}
