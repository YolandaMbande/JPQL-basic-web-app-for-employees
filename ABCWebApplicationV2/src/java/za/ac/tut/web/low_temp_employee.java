/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.entities.EmployeeFacadeLocal;
import za.ac.tut.entity.Employee;


public class low_temp_employee extends HttpServlet {
@EJB EmployeeFacadeLocal efl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employees = efl.getLowTemperatures();
        request.setAttribute("employees", employees);
        
        RequestDispatcher disp = request.getRequestDispatcher("low_temp_outcome.jsp");
        disp.forward(request, response);
    }
}
