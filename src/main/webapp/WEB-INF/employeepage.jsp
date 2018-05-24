<%-- 
    Document   : newjspemployeepage
    Created on : Mar 28, 2018, 2:18:28 AM
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
        <title>Employee page</title>
    </head>
    <body>
        <h1>Lego House</h1>

        <form name="Logout" action="" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout">
        </form>

        <h1>Orders</h1>
        <div>
            <table class="table table-hover">
                <thead class="thead-dark">
                <th>User id</th>
                <th>Order id</th>
                <th>Length</th>
                <th>Width</th>
                <th>Height</th>
                <th>Blocks</th>
                <th>Status</th>
                <th>Send order</th>
                </thead>
                <tbody>

                    <c:forEach var="o" items="${orders}">
                        <tr>
                            <td>${o.user_iduser}</td>
                            <td>${o.idorder}</td>
                            <td>${o.length}</td>
                            <td>${o.width}</td>
                            <td>${o.height}</td>
                            <td>${o.blocks}</td>
                            <td>${o.status.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${o.status.name eq 'pending'}">
                                        <form name="SendOrder" action="" method="POST">
                                            <input type="hidden" name="command" value="sendOrder">
                                            <input type="hidden" name="idorder" value=${o.idorder}>
                                            <input type="submit" value="Send order">
                                        </form>
                                        </c:when> 
                                        <c:otherwise>
                                        Order sent
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
