package com.crud.controller;

import com.crud.configuracion.BeanFormulario;
import com.crud.entidades.Marcas;
import com.crud.entidades.Vehiculos;
import com.crud.interfaz.MarcasFacadeLocal;
import com.crud.interfaz.VehiculosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author mpluas
 */
@ManagedBean(name = "vehiculosController")
@ViewScoped
public class vehiculosController extends BeanFormulario implements Serializable {
    @EJB
    private VehiculosFacadeLocal vehiculosEJB;
    @EJB
    private MarcasFacadeLocal marcasEJB;
    
    private List<Vehiculos> listaVehiculos;
    private List<Marcas> listaMarcas;
    private Vehiculos vehiculos;
    private Marcas marcas;
    private Boolean listaInformacionVehiculo;
    private Boolean editarVehiculo;
    private Boolean nuevoVehiculo;
    
    @PostConstruct
    public void init() {
        this.listaInformacionVehiculo = true;
        this.editarVehiculo = false;
        this.nuevoVehiculo = false;
        this.vehiculos = new Vehiculos();
        this.marcas = new Marcas();
        listaVehiculos = vehiculosEJB.findAll();
        listaMarcas = marcasEJB.findAll();
    }

    public void vehiculoSeleccionadoEdicion(ActionEvent evento) {
        System.out.println("!---- Editar Vehiculo ----!");
        this.vehiculos = (Vehiculos) evento.getComponent().getAttributes().get("vehiculo");
        this.listaInformacionVehiculo = false;
        this.editarVehiculo = true;
    }    

    public void eliminarVehiculo(Vehiculos vehiculo) {
        try {
            vehiculosEJB.remove(vehiculo);
            addMensaje("El vehiculo fue eliminado correctamente");
            init();
        } catch (Exception e) {
            addError("Error");
        }
    } 
    
    public boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    
    public String crear() {
        try {
            if (this.isNumeric(this.vehiculos.getAnio().toString()) == false) {
                addError("El campo Niveles debe ser numerico");
                return "";
            }
            vehiculosEJB.create(this.vehiculos);
            addMensaje("El vehiculo se creo correctamente");
            System.out.println("!---- Vehiculo Creado ----!");
            init();
        } catch (Exception e) {
            addError("No se pudo realizar la transaccion");
            System.out.println("ERROR");
        }
        return "";
    }
    
    public String actualizar() {
        try {
            vehiculosEJB.edit(this.vehiculos);
            //addMensaje("Mascota " + this.mascotas.getNombre()+ " actualizado con éxito");
            addMensaje("El vehiculo se actualizo correctamente");
            System.out.println("!---- Vehiculo Actualizado ----!");
            init();
        } catch (Throwable e) {
            addError("Error al realizar la transacción");
            System.out.println("ERROR");
        }
            return "";
    }
    
    public void crearVehiculo(ActionEvent evento) {
        this.vehiculos = new Vehiculos();
        this.listaInformacionVehiculo = false;
        this.nuevoVehiculo = true;
    }
    
    public List<Vehiculos> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Boolean getListaInformacionVehiculo() {
        return listaInformacionVehiculo;
    }

    public void setListaInformacionVehiculo(Boolean listaInformacionVehiculo) {
        this.listaInformacionVehiculo = listaInformacionVehiculo;
    }

    public Boolean getEditarVehiculo() {
        return editarVehiculo;
    }

    public void setEditarVehiculo(Boolean editarVehiculo) {
        this.editarVehiculo = editarVehiculo;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Marcas> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<Marcas> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public Boolean getNuevoVehiculo() {
        return nuevoVehiculo;
    }

    public void setNuevoVehiculo(Boolean nuevoVehiculo) {
        this.nuevoVehiculo = nuevoVehiculo;
    }

}
