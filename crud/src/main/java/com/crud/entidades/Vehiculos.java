package com.crud.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mpluas
 */
@Entity
@Table(name = "VEHICULOS")
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEC_VEHICULO_RES", initialValue=1, allocationSize=1, schema="SYSTEM", sequenceName="SEC_VEHICULO_RES_PK")
    @GeneratedValue(generator="SEC_VEHICULO_RES", strategy=GenerationType.SEQUENCE)
    @Column(name = "ID_VEHICULO")
    private BigDecimal idVehiculo;
    @Size(max = 255)
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @Column(name = "ANIO")
    private BigInteger anio;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marcas idMarca;

    public Vehiculos() {
    }

    public Vehiculos(BigDecimal idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public BigDecimal getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(BigDecimal idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }
    
}