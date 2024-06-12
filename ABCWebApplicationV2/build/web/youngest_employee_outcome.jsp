<%-- 
    Document   : youngest_employee_outcome
    Created on : 11 Jun 2024, 16:43:14
    Author     : yolan
--%>

<%@page import="za.ac.tut.entity.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Temperature"%>
<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Youngest Employee Outcome Page</title>
    </head>
    <body>
        <h1>Youngest Recorded Employee</h1>
        <p>
            Below are the details of the youngest recorded employee in the database:
        </p>
        <%
            Employee employee = (Employee)request.getAttribute("employee");
        %>
        <table border='1'>
            <tr>
                <td>Name : </td>
                <td><%= employee.getName() %></td>
            </tr>
            <tr>
                <td>Outcome : </td>
                <td><%= employee.getOutcome()%></td>
            </tr>
            <tr>
                <td>Image : </td>
                <td><img src="data:jpeg/image;base64, <%= Base64.getEncoder().encodeToString(employee.getImage())%>"></td>
            </tr>
            <tr>
                <td>Temperature : </td>
                <td>
                    <%
                        List<Temperature> temps = employee.getTemperature();
                        for(Temperature t: temps)
                        {
                        %>
                        <ul>
                            <li><%= t.getTemperatures() %></li>
                        </ul>
                        <%
                            }
                    %>
                </td>
            </tr>
            <tr>
                <td>Subjects : </td>
                <td>
                    <%
                        List<Subjects> subjects = employee.getSubjects();
                        for(Subjects s: subjects)
                        {
                        %>
                        <ul>
                            <li><%= s.getCode() %></li>
                        </ul>
                        <%
                        }
                    %>
                </td>
            </tr>
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
