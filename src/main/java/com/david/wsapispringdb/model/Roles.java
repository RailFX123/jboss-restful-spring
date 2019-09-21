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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_roles")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "rol", allowGetters = false)
public class Roles implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rol;

   
    private String descripcion;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "rol")
    private List<Credenciales> rol;

    /**
     * @return the id_rol
     */
    public Long getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
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
     * @return the rol
     */
    public List<Credenciales> getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(List<Credenciales> rol) {
        this.rol = rol;
    }


}
