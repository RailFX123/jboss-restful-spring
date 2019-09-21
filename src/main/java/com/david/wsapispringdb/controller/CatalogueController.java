/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.controller;

import com.david.wsapispringdb.exception.ResourceNotFoundException;
import com.david.wsapispringdb.model.EstadoMarital;
import com.david.wsapispringdb.model.Genero;
import com.david.wsapispringdb.model.Intereses;
import com.david.wsapispringdb.model.Roles;
import com.david.wsapispringdb.model.TiposCliente;
import com.david.wsapispringdb.model.Usuarios;
import com.david.wsapispringdb.repository.EstadoMaritalRepository;
import com.david.wsapispringdb.repository.GeneroRepository;
import com.david.wsapispringdb.repository.InteresesRepository;
import com.david.wsapispringdb.repository.RolesRespository;
import com.david.wsapispringdb.repository.TiposClienteRepository;
import com.david.wsapispringdb.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/cataloguemanagement")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CatalogueController {

    @Autowired
    EstadoMaritalRepository estadoMaritalRepository;

    @Autowired
    GeneroRepository generoRepository;

    @Autowired
    TiposClienteRepository tiposClienteRepository;

    @Autowired
    InteresesRepository interesesRepository;

    @Autowired
    UsuarioRepository usuariosRepository;

    @Autowired
    RolesRespository rolesRepository;

    // Obtener todos los usuarios
    @GetMapping("/estadosmaritales")
    public List<EstadoMarital> getAllMaritalStates() {
        return estadoMaritalRepository.findAll();
    }

    // Obtener todos los usuarios
    @GetMapping("/generos")
    public List<Genero> getAllGenders() {
        return generoRepository.findAll();
    }

    // Obtener todos los usuarios
    @GetMapping("/tusuarios/{id}")
    public TiposCliente getAlltUserTypes(@PathVariable(value = "id") Long noteId) {
        Usuarios user = usuariosRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
        return user.getTiposCliente();
    }

    @GetMapping("/tusuarios")
    public TiposCliente getAlltUser(@PathVariable(value = "id") Long noteId) {
        Usuarios user = usuariosRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
        return user.getTiposCliente();
    }

    // Obtener todos los usuarios
    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    // Obtener todos los usuarios
    @GetMapping("/quotas")
    public List<Intereses> getQuotaListByUserID() {
        return interesesRepository.findAll();
    }

}
