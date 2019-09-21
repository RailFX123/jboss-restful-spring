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
@Table(name = "tb_Generos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "usuarios",allowGetters = false)
public class Genero implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_genero;

    @NotBlank
    private String descripcion;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "generoPersonal")
    private List<Usuarios> usuarios;

    /**
     * @return the id_genero
     */
    public Long getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
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
