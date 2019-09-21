/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_pagos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "pagosRealizados", allowGetters = false)
public class Pagos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pago;

    private String tarjeta_credito;

    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @CreatedDate
    private Date fecha_pag;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_cuota", referencedColumnName = "id_cuota")
    private Cuotas pagosRealizados;

    /**
     * @return the id_pago
     */
    public Long getId_pago() {
        return id_pago;
    }

    /**
     * @param id_pago the id_pago to set
     */
    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    /**
     * @return the fecha_pag
     */
    public Date getFecha_pag() {
        return fecha_pag;
    }

    /**
     * @param fecha_pag the fecha_pag to set
     */
    public void setFecha_pag(Date fecha_pag) {
        this.fecha_pag = fecha_pag;
    }

    /**
     * @return the pagosRealizados
     */
    public Cuotas getPagosRealizados() {
        return pagosRealizados;
    }

    /**
     * @param pagosRealizados the pagosRealizados to set
     */
    public void setPagosRealizados(Cuotas pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    /**
     * @return the tarjeta_credito
     */
    public String getTarjeta_credito() {
        return tarjeta_credito;
    }

    /**
     * @param tarjeta_credito the tarjeta_credito to set
     */
    public void setTarjeta_credito(String tarjeta_credito) {
        this.tarjeta_credito = tarjeta_credito;
    }

}
