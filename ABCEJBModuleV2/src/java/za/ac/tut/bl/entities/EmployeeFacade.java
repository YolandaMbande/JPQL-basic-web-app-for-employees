/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entity.Employee;
import za.ac.tut.entity.Temperature;

/**
 *
 * @author yolan
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "ABCEJBModuleV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public void determineTemperatureReading() {
       List<Employee> employees = em.createQuery("SELECT e FROM Employee e JOIN FETCH e.temperature", Employee.class).getResultList();
       for(Employee emps: employees)
       {
           boolean outcome = false;
           for(Temperature temp: emps.getTemperature())
           {
              if(temp.getTemperatures() > 38.0)
              {
                  outcome = true;
                  break;
              }
           }
           if(outcome)
           {
               emps.setOutcome("High");
           }else{
               emps.setOutcome("Acceptable");
           }
           em.merge(emps);
       }
    }

    @Override
    public List<Employee> getHighTemperatures() {
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.outcome = 'High'", Employee.class).getResultList();
        
        return employees;
    }

    @Override
    public List<Employee> getLowTemperatures() {
       List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.outcome = 'Acceptable'", Employee.class).getResultList();
        
        return employees;
    }

    @Override
    public List<Employee> gotHighTemperatureTwice() {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE "
                + "(SELECT COUNT(t) FROM Temperature t WHERE t.employee = e AND t.temperatures > 38.0) > 1");
        List<Employee> emps = query.getResultList();
        return emps;
    }

    @Override
    public Employee getYoungestEmployee() {
        Query query = em.createQuery("SELECT e FROM Employee e ORDER BY e.age ASC");
        query.setMaxResults(1);
        Employee emp = (Employee)query.getSingleResult();
        return emp;
    }
    
}
