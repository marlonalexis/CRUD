package com.crud.dao;

import com.crud.interfaz.MarcasFacadeLocal;
import com.crud.entidades.Marcas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mpluas
 */
@Stateless
public class MarcasFacade extends AbstractFacade<Marcas> implements MarcasFacadeLocal {

    @PersistenceContext(unitName = "crudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }
    
}
