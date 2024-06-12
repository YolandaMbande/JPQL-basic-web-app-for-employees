
package za.ac.tut.bl.entities;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Employee;


@Local
public interface EmployeeFacadeLocal {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
    void determineTemperatureReading();
    
    List<Employee> getHighTemperatures();
    
    List<Employee> getLowTemperatures();
    
    List<Employee> gotHighTemperatureTwice();
    
    Employee getYoungestEmployee();
}
