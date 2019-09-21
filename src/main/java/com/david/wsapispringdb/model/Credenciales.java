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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_credenciales")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"usuarios"}, allowGetters = false)
public class Credenciales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_credencial;

    @NotBlank
    private String correo;

    @NotBlank
    private String contrasena;

    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Roles rol;
    
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy = "credencial")
    private Usuarios usuarios;

    /**
     * @return the id_credencial
     */
    public Long getId_credencial() {
        return id_credencial;
    }

    /**
     * @param id_credencial the id_credencial to set
     */
    public void setId_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the rol
     */
    public Roles getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Roles rol) {
        this.rol = rol;
    }

    /**
     * @return the usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }


}
