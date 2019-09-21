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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_cuotas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "prestamo", allowGetters = false)
public class Cuotas implements Serializable {

    @Id
    private Long id_cuota;

    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_limite_pago;

    private Double monto;

    private String estado;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    private Prestamos prestamo;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "pagosRealizados")
    private Pagos cuotasPagos;

    private Integer cuota_num;

    /**
     * @return the id_cuota
     */
    public Long getId_cuota() {
        return id_cuota;
    }

    /**
     * @param id_cuota the id_cuota to set
     */
    public void setId_cuota(Long id_cuota) {
        this.id_cuota = id_cuota;
    }

    /**
     * @return the fecha_limite_pago
     */
    public Date getFecha_limite_pago() {
        return fecha_limite_pago;
    }

    /**
     * @param fecha_limite_pago the fecha_limite_pago to set
     */
    public void setFecha_limite_pago(Date fecha_limite_pago) {
        this.fecha_limite_pago = fecha_limite_pago;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
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
     * @return the prestamo
     */
    public Prestamos getPrestamo() {
        return prestamo;
    }

    /**
     * @param prestamo the prestamo to set
     */
    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * @return the cuotasPagos
     */
    public Pagos getCuotasPagos() {
        return cuotasPagos;
    }

    /**
     * @param cuotasPagos the cuotasPagos to set
     */
    public void setCuotasPagos(Pagos cuotasPagos) {
        this.cuotasPagos = cuotasPagos;
    }

    /**
     * @return the cuota_num
     */
    public Integer getCuota_num() {
        return cuota_num;
    }

    /**
     * @param cuota_num the cuota_num to set
     */
    public void setCuota_num(Integer cuota_num) {
        this.cuota_num = cuota_num;
    }

}
