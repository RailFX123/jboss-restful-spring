/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_cantidad_cuotas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"cuotasg","cuotasP"}, allowGetters = false)
public class CantidadCuotas implements Serializable {

    @Id
    private Long id_cantidad_cuota;

    private Long Cantidad_Cuotas;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "cantidadCuotas")
    private List<Intereses> cuotasg;

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
     * @return the Cantidad_Cuotas
     */
    public Long getCantidad_Cuotas() {
        return Cantidad_Cuotas;
    }

    /**
     * @param Cantidad_Cuotas the Cantidad_Cuotas to set
     */
    public void setCantidad_Cuotas(Long Cantidad_Cuotas) {
        this.Cantidad_Cuotas = Cantidad_Cuotas;
    }

    /**
     * @return the cuotasg
     */
    public List<Intereses> getCuotasg() {
        return cuotasg;
    }

    /**
     * @param cuotasg the cuotasg to set
     */
    public void setCuotasg(List<Intereses> cuotasg) {
        this.cuotasg = cuotasg;
    }
}
