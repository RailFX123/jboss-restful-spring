/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_prestamos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "cuotasPrestamo", allowGetters = false)
public class Prestamos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_prestamo;

    private Double monto_solicitado;

    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_inicio;

    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_final;

    private Long id_usuario;
    
    private Long id_cantidad_cuota;
    
    private String descripcion;
    
    private String estado;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "prestamo")
    private List<Cuotas> cuotas;
    
    
    private Double monto_real;

    /**
     * @return the id_prestamo
     */
    public Long getId_prestamo() {
        return id_prestamo;
    }

    /**
     * @param id_prestamo the id_prestamo to set
     */
    public void setId_prestamo(Long id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    /**
     * @return the monto_solicitado
     */
    public Double getMonto_solicitado() {
        return monto_solicitado;
    }

    /**
     * @param monto_solicitado the monto_solicitado to set
     */
    public void setMonto_solicitado(Double monto_solicitado) {
        this.monto_solicitado = monto_solicitado;
    }

    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_final
     */
    public Date getFecha_final() {
        return fecha_final;
    }

    /**
     * @param fecha_final the fecha_final to set
     */
    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    /**
     * @return the monto_real
     */
    public Double getMonto_real() {
        return monto_real;
    }

    /**
     * @param monto_real the monto_real to set
     */
    public void setMonto_real(Double monto_real) {
        this.monto_real = monto_real;
    }

    /**
     * @return the id_usuario
     */
    public Long getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the cuotas
     */
    public List<Cuotas> getCuotas() {
        return cuotas;
    }

    /**
     * @param cuotas the cuotas to set
     */
    public void setCuotas(List<Cuotas> cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * @return the id_cantidad_cuota
     */
    public Long getId_cantidad_cuota() {
        return id_cantidad_cuota;
    }

    /**
     * @param id_cantidad_cuota the id_cantidad_cuota to set
     */
    public void setId_cantidad_cuota(Long id_cantidad_cuota) {
        this.id_cantidad_cuota = id_cantidad_cuota;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
