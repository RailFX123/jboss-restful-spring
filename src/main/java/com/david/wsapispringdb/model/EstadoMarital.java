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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_estados_maritales")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "usuarios", allowGetters = false)
public class EstadoMarital implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_estado_marital;

    @NotBlank
    private String descripcion;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "estadoMarital")
    private List<Usuarios> usuarios;

    /**
     * @return the id_estado_marital
     */
    public Long getId_estado_marital() {
        return id_estado_marital;
    }

    /**
     * @param id_estado_marital the id_estado_marital to set
     */
    public void setId_estado_marital(Long id_estado_marital) {
        this.id_estado_marital = id_estado_marital;
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

    /**
     * @return the usuarios
     */
    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

}
