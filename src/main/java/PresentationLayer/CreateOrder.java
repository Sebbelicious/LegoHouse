/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author s_ele
 */
public class CreateOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LogicFacade.createOrder(user, length, width, height);
        
        List<Order> orders = LogicFacade.getOrdersCustomer(user);
        request.setAttribute("orders", orders);
        request.setAttribute("message", "Your order was successfull");
        return user.getRole().getName() + "page";
    }
    
}
