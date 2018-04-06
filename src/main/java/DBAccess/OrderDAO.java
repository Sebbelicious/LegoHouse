/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.Order.OrderStatus;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s_ele
 */
public class OrderDAO {

    public static void createOrder(User user, Order order) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO order (length, width, height, status, user_userid) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setString(4, order.getStatus().getName());
            ps.setInt(5, user.getIduser());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int idorder = ids.getInt(1);
            order.setIdorder(idorder);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static List<Order> getOrdersCustomer(User user) throws LoginSampleException {
        try {
            List<Order> orders = new ArrayList();
            Connection con = DBConnector.connection();
            String SQL = "SELECT idorder, length, width, height, status FROM order "
                    + "WHERE user_iduser=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            int user_iduser = user.getIduser();
            ps.setInt(1, user_iduser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idorder = rs.getInt("idorder");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                OrderStatus status = OrderStatus.valueOf(rs.getString("status"));
                Order order = new Order(length, width, height, status, user_iduser);
                order.setIdorder(idorder);

                orders.add(order);
            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<Order> getOrdersEmployee() throws LoginSampleException {
        try {
            List<Order> orders = new ArrayList();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM order";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idorder = rs.getInt("idorder");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                OrderStatus status = OrderStatus.valueOf(rs.getString("status"));
                int user_iduser = rs.getInt("user_iduser");
                Order order = new Order(length, width, height, status, user_iduser);
                order.setIdorder(idorder);

                orders.add(order);
            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}//CLASS
