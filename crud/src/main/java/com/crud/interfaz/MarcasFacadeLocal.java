package com.crud.interfaz;

import com.crud.entidades.Marcas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mpluas
 */
@Local
public interface MarcasFacadeLocal {

    void create(Marcas marcas);

    void edit(Marcas marcas);

    void remove(Marcas marcas);

    Marcas find(Object id);

    List<Marcas> findAll();

    List<Marcas> findRange(int[] range);

    int count();
    
}
