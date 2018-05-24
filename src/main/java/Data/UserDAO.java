/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.User.UserRole;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author s_ele
 */
public class UserDAO {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().getName());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int iduser = ids.getInt(1);
            user.setIduser(iduser);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT iduser, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int iduser = rs.getInt("iduser");
                UserRole role = UserRole.valueOf(rs.getString("role"));
                User user = new User(email, password, role);
                user.setIduser(iduser);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
