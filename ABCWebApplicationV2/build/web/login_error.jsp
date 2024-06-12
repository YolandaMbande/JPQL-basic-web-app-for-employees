<%-- 
    Document   : login_error
    Created on : 12 Jun 2024, 13:18:30
    Author     : yolan
--%>

<%@page contentType="text/html" isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
    </head>
    <body>
        <h1>Log In Page</h1>
        <p style='color: red'>
            Invalid log in details!
        </p>
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="j_username" required=""></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="j_password" required=""></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
