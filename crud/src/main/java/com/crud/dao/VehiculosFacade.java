package com.crud.dao;

import com.crud.interfaz.VehiculosFacadeLocal;
import com.crud.entidades.Vehiculos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mpluas
 */
@Stateless
public class VehiculosFacade extends AbstractFacade<Vehiculos> implements VehiculosFacadeLocal {

    @PersistenceContext(unitName = "crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculosFacade() {
        super(Vehiculos.class);
    }
    
}
