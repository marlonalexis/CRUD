package com.crud.interfaz;

import com.crud.entidades.Vehiculos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mpluas
 */
@Local
public interface VehiculosFacadeLocal {

    void create(Vehiculos vehiculos);

    void edit(Vehiculos vehiculos);

    void remove(Vehiculos vehiculos);

    Vehiculos find(Object id);

    List<Vehiculos> findAll();

    List<Vehiculos> findRange(int[] range);

    int count();
    
}
