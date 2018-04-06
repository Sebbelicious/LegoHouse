/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.OrderDAO;
import DBAccess.UserDAO;
import FunctionLayer.Order.OrderStatus;
import FunctionLayer.User.UserRole;
import java.util.List;

/**
 *
 * @author s_ele
 */
public class LogicFacade {
    
    public static User login( String email, String password ) throws LoginSampleException {
        return UserDAO.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, UserRole.valueOf("customer"));
        UserDAO.createUser( user );
        return user;
    }
    
    public static Order createOrder(User user, int length, int width, int height, OrderStatus status) throws LoginSampleException {
        Order order = new Order(length, width, height, status, user.getIduser());
        OrderDAO.createOrder(user, order);
        return order;
    }
    
    public static List<Order> getOrdersCustomer(User user) throws LoginSampleException {
        return OrderDAO.getOrdersCustomer(user);
    }
    
    public static List<Order> getOrdersEmployee() throws LoginSampleException {
        return OrderDAO.getOrdersEmployee();
    }
    
    
}//CLASS
