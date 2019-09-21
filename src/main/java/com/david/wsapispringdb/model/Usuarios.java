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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tb_usuarios")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"fechaCreacion", "fechaActualizacion"}, allowGetters = false)
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotNull(message = "salary may not be empty")
    @Range(min = 1)
    private Long edad;

    @NotBlank
    private String dpi;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_tipo_cliente", referencedColumnName = "id_tipo_cliente")
    private TiposCliente tiposCliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_estado_marital", referencedColumnName = "id_estado_marital")
    private EstadoMarital estadoMarital;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name = "id_credencial", referencedColumnName = "id_credencial")
    @MapsId
    private Credenciales credencial;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    private Genero generoPersonal;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date fechaCreacion;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date fechaActualizacion;


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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public Long getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Long edad) {
        this.edad = edad;
    }

    /**
     * @return the dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the tiposCliente
     */
    public TiposCliente getTiposCliente() {
        return tiposCliente;
    }

    /**
     * @param tiposCliente the tiposCliente to set
     */
    public void setTiposCliente(TiposCliente tiposCliente) {
        this.tiposCliente = tiposCliente;
    }

    /**
     * @return the estadoMarital
     */
    public EstadoMarital getEstadoMarital() {
        return estadoMarital;
    }

    /**
     * @param estadoMarital the estadoMarital to set
     */
    public void setEstadoMarital(EstadoMarital estadoMarital) {
        this.estadoMarital = estadoMarital;
    }

    /**
     * @return the credencial
     */
    public Credenciales getCredencial() {
        return credencial;
    }

    /**
     * @param credencial the credencial to set
     */
    public void setCredencial(Credenciales credencial) {
        this.credencial = credencial;
    }

    /**
     * @return the generoPersonal
     */
    public Genero getGeneroPersonal() {
        return generoPersonal;
    }

    /**
     * @param generoPersonal the generoPersonal to set
     */
    public void setGeneroPersonal(Genero generoPersonal) {
        this.generoPersonal = generoPersonal;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
