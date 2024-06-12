/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Temperature;

/**
 *
 * @author yolan
 */
@Stateless
public class TemperatureFacade extends AbstractFacade<Temperature> implements TemperatureFacadeLocal {

    @PersistenceContext(unitName = "ABCEJBModuleV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TemperatureFacade() {
        super(Temperature.class);
    }
    
}
