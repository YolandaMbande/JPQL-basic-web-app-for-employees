<%-- 
    Document   : high_twice_outcome
    Created on : 11 Jun 2024, 15:39:02
    Author     : yolan
--%>

<%@page import="za.ac.tut.entity.Temperature"%>
<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>High Temperature Outcome Page</title>
    </head>
    <body>
        <h1>High Temperature Recorded Twice Employees</h1>
        <p>
            Below is the list of all employees with high temperatures recorded twice or more:
        </p>
        <body>
            <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                if (employees != null && !employees.isEmpty()) {
                    for (Employee e : employees) {
            %>
            <table border="1">
                <tr>
                    <td>Name :</td>
                    <td><%= e.getName() %></td>
                </tr>
                <tr>
                    <td>Outcome :</td>
                    <td><%= e.getOutcome() %></td>
                </tr>
                <tr>
                    <td>Image :</td>
                    <td><img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(e.getImage()) %>" /></td>
                </tr>
                <tr>
                    <td>Temperature(s) :</td>
                    <td>
                        <ul>
                            <%
                                List<Temperature> temperatures = e.getTemperature();
                                for (Temperature tt : temperatures) {
                            %>
                            <li><%= tt.getTemperatures() %></li>
                            <%
                                }
                            %>
                        </ul>
                    </td>
                </tr>
            </table>
            <br/>
            <%
                    }
                } else {
            %>
            <p>No employees with high temperatures found.</p>
            <%
                }
            %>
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


