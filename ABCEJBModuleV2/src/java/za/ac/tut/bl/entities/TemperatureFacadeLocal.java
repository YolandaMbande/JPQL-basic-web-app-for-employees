/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.bl.entities;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Temperature;

/**
 *
 * @author yolan
 */
@Local
public interface TemperatureFacadeLocal {

    void create(Temperature temperature);

    void edit(Temperature temperature);

    void remove(Temperature temperature);

    Temperature find(Object id);

    List<Temperature> findAll();

    List<Temperature> findRange(int[] range);

    int count();
    
}
