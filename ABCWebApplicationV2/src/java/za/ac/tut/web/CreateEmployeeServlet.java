
package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.bl.entities.EmployeeFacadeLocal;
import za.ac.tut.entity.Employee;
import za.ac.tut.entity.Subjects;
import za.ac.tut.entity.Temperature;

@WebServlet("/create_employee")
@MultipartConfig
public class CreateEmployeeServlet extends HttpServlet {
@EJB EmployeeFacadeLocal efl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String[] tempStr = request.getParameterValues("temps[]");
        String[] subjects = request.getParameterValues("subjects[]");
        Part filePart = request.getPart("image");
        InputStream input = filePart.getInputStream();
        byte[] image = createImage(input);
        
        Employee e = new Employee();
        List<Temperature> t = new ArrayList<>();
        for(String s: tempStr)
        {
            Temperature tt = new Temperature();
            Double temperature = Double.valueOf(s);
            tt.setTemperatures(temperature);
            tt.setEmployee(e);
            t.add(tt);
        }
        List<Subjects> done = new ArrayList<>();
        for(String s: subjects)
        {
            Subjects sub = new Subjects();
            sub.setCode(s);
            sub.setEmployee(e);
            done.add(sub);
        }
        e.setName(name);
        e.setImage(image);
        e.setTemperature(t);
        e.setSubjects(done);
        
        efl.create(e);
        efl.determineTemperatureReading();
        
        RequestDispatcher disp = request.getRequestDispatcher("created_outcome.jsp");
        disp.forward(request, response);
    }

    private byte[] createImage(InputStream input) throws IOException {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte[] buffer = new byte[4096];
      int read;
      
        while((read = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, read);
        }
      
      return output.toByteArray();
    }
}
