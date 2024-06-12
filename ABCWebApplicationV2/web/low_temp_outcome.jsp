<%-- 
    Document   : low_temp_outcome
    Created on : 11 Jun 2024, 15:34:43
    Author     : yolan
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Employee"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>High Temperature Outcome Page</title>
    </head>
    <body>
        <h1>Low Temperature Recorded Employees</h1>
        <p>
            Below is the list of all employees with high temperatures:
        </p>
        <%
            List<Employee> employees = (List<Employee>)request.getAttribute("employees");
            for(Employee e: employees)
            {
        %>
        <table border="1">
            <tr>
                <td>Name : </td>
                <td><%= e.getName() %></td>
            </tr>
            <tr>
                <td>Outcome : </td>
                <td><%= e.getOutcome() %></td>
            </tr>
            <tr>
                <td>Image : </td>
                <td><img src="data:jpeg/image;base64, <%= Base64.getEncoder().encodeToString(e.getImage()) %>"></td>
            </tr>
            <%
                }
            %>
        </table>
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
