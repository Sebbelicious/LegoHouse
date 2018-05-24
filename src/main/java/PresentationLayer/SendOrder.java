/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s_ele
 */
public class SendOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        int idorder = Integer.parseInt(request.getParameter("idorder"));
        LogicFacade.updateOrderStatus(idorder);
        List<Order> orders = LogicFacade.getOrdersEmployee();
        request.setAttribute("orders", orders);
        return "employeepage";
    }
    
}
