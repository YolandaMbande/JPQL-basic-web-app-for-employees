<%-- 
    Document   : access_denied
    Created on : 12 Jun 2024, 13:27:46
    Author     : yolan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied Page</title>
    </head>
    <body>
        <h1>Access Denied!</h1>
        <p style='color: red'>
            <b>
                You're not authorized in this page!
            </b>
        </p>
         <p>
            <i>
                Please click <a href="menu.html">here</a> to return.
            </i>
        </p>
        <p>
            <i>
                Please click <a href="LogOutServlet.do">here</a> to log out.
            </i>
        </p>
    </body>
</html>
