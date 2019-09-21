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
@Table(name = "tb_tipo_clientes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"usuarios"}, allowGetters = false)
public class TiposCliente implements Serializable {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tipo_cliente;

    @NotBlank
    private String descripcion;

    private Long valor;

    private Long mora;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "tiposCliente")
    private List<Usuarios> usuarios;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "tipoCliente")
    private List<Intereses> clienteIntereses;

    /**
     * @return the id_tipo_cliente
     */
    public Long getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    /**
     * @param id_tipo_cliente the id_tipo_cliente to set
     */
    public void setId_tipo_cliente(Long id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
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
     * @return the valor
     */
    public Long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }

    /**
     * @return the mora
     */
    public Long getMora() {
        return mora;
    }

    /**
     * @param mora the mora to set
     */
    public void setMora(Long mora) {
        this.mora = mora;
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

    /**
     * @return the clienteIntereses
     */
    public List<Intereses> getClienteIntereses() {
        return clienteIntereses;
    }

    /**
     * @param clienteIntereses the clienteIntereses to set
     */
    public void setClienteIntereses(List<Intereses> clienteIntereses) {
        this.clienteIntereses = clienteIntereses;
    }

  
    
}
