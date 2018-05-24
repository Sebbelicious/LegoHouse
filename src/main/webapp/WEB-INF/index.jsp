<%-- 
    Document   : index
    Created on : Mar 28, 2018, 2:17:18 AM
    Author     : s_ele
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lego House</title>
    </head>
    <body>
        <h1>Lego House Builder</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="employee1@legobuilder.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="ilovelego">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="name@mail.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="password123">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="password123">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        
        Need help? <a href="FrontController?command=help">Click here! </a>
                     
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>
