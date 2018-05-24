<%-- 
    Document   : customerpager
    Created on : Mar 28, 2018, 2:18:17 AM
    Author     : s_ele
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    <body>
        <h1>Lego House</h1>
        
        
        <form name="Logout" action="" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout">
        </form>
        
        
        
        <h3> Make new order </h3>
        <table>
            <tr>
                <td>
                    <form name="CreateOrder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="createOrder">
                        Length in dots:<br>
                        <input type="number" name="length" min="2" max="500" required>
                        <br>
                        Width in dots:<br>
                        <input type="number" name="width" min="2" max="500" required>
                        <br>
                        Height in blocks:<br>
                        <input type="number" name="height" min="2" max="100" required>
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        
        <h1>Orders</h1>
        <div>
            <table class="table table-hover">
                <thead class="thead-dark">
                <th>Order id</th>
                <th>Length</th>
                <th>Width</th>
                <th>Height</th>
                <th>Blocks</th>
                <th>Status</th>
                </thead>
                <tbody>

                    <c:forEach var="o" items="${orders}">
                        <tr>
                            <td>${o.idorder}</td>
                            <td>${o.length}</td>
                            <td>${o.width}</td>
                            <td>${o.height}</td>
                            <td>${o.blocks}</td>
                            <td>${o.status.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
