package com.crud.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mpluas
 */
@Entity
@Table(name = "MARCAS")
public class Marcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SEC_MARCA_RES", initialValue=1, allocationSize=1, schema="SYSTEM", sequenceName="SEC_MARCA_RES_PK")
    @GeneratedValue(generator="SEC_MARCA_RES", strategy=GenerationType.SEQUENCE)
    @Column(name = "ID_MARCA")
    private BigDecimal idMarca;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idMarca")
    private List<Vehiculos> vehiculosList;

    public Marcas() {
    }

    public Marcas(BigDecimal idMarca) {
        this.idMarca = idMarca;
    }

    public BigDecimal getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(BigDecimal idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }
    
}