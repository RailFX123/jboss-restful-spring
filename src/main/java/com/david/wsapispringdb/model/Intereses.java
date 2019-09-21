/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_intereses")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"tipoCliente"}, allowGetters = false)
public class Intereses implements Serializable {

    @Id
    private Long id_interes;

    private Double porcentaje_interes;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_tipo_cliente", referencedColumnName = "id_tipo_cliente")
    private TiposCliente tipoCliente;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_cantidad_cuota", referencedColumnName = "id_cantidad_cuota")
    private CantidadCuotas cantidadCuotas;
    /**
     * @return the id_interes
     */
    public Long getId_interes() {
        return id_interes;
    }

    /**
     * @param id_interes the id_interes to set
     */
    public void setId_interes(Long id_interes) {
        this.id_interes = id_interes;
    }

    /**
     * @return the porcentaje_interes
     */
    public Double getPorcentaje_interes() {
        return porcentaje_interes;
    }

    /**
     * @param porcentaje_interes the porcentaje_interes to set
     */
    public void setPorcentaje_interes(Double porcentaje_interes) {
        this.porcentaje_interes = porcentaje_interes;
    }

    /**
     * @return the tipoCliente
     */
    public TiposCliente getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @param tipoCliente the tipoCliente to set
     */
    public void setTipoCliente(TiposCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * @return the cantidadCuotas
     */
    public CantidadCuotas getCantidadCuotas() {
        return cantidadCuotas;
    }

    /**
     * @param cantidadCuotas the cantidadCuotas to set
     */
    public void setCantidadCuotas(CantidadCuotas cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

   
}
