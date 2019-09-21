/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.controller;

import com.david.wsapispringdb.exception.ResourceConflictException;
import com.david.wsapispringdb.exception.ResourceNotFoundException;
import com.david.wsapispringdb.model.Credenciales;
import com.david.wsapispringdb.model.MailClass;
import com.david.wsapispringdb.model.Usuarios;
import com.david.wsapispringdb.repository.CredencialesRepository;
import com.david.wsapispringdb.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/accountmanagement")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class UsersController {

    @Autowired
    UsuarioRepository usuariosRepository;
    @Autowired
    CredencialesRepository credencialRepository;

    // Obtener todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuarios> getAllusers() {
        return usuariosRepository.findAll();
    }

    // Crear un nuevo usuario
    @PostMapping("/usuarios")
    public Usuarios createUser(@Valid @RequestBody Usuarios usuario) {
        Optional<Usuarios> ok = usuariosRepository.findUserByCredencialCorreo(usuario.getCredencial().getCorreo());
        if (ok.isPresent()) {
            throw new ResourceConflictException("else", "else", "else");
        } else {
            new MailClass().SendMail(usuario.getNombre(), usuario.getCredencial().getCorreo(), 1005274, "Bienvenido a ClavaFacil");
            return usuariosRepository.save(usuario);
        }
    }

    // Crear un nuevo usuario
    @PostMapping("/login")
    public Usuarios loginUser(@Valid @RequestBody Credenciales credencial) {
        Credenciales cred = credencialRepository.findLoginUser(credencial.getCorreo(), credencial.getContrasena())
                .orElseThrow(() -> new ResourceNotFoundException("Credenciales", "contraseña y usuario ", credencial.getContrasena() + " || " + credencial.getCorreo()));
        Usuarios user = usuariosRepository.findUserByCredencial(cred.getId_credencial()).orElseThrow(() -> new ResourceNotFoundException("Credenciales", "id", "Poquechi"));
        return user;
    }

    //Obtener un usuario por ID
    @GetMapping("/usuarios/{id}")
    public Usuarios getUserByID(@PathVariable(value = "id") Long noteId) {
        return usuariosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
    }

    //Actualizar usuario por ID
    @PutMapping("/usuarios/{id}")
    public Usuarios updateUser(@PathVariable(value = "id") Long noteId,
            @Valid @RequestBody Usuarios usuariodetails) {

        Usuarios usuario = usuariosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
        usuario.getCredencial().setCorreo(usuariodetails.getCredencial().getCorreo());
        //usuario.setDpi(usuariodetails.getDpi());
        usuario.setEdad(usuariodetails.getEdad());
        usuario.setNombre(usuariodetails.getNombre());
        usuario.setApellido(usuariodetails.getApellido());
        //usuario.setEstadoMarital(usuariodetails.getEstadoMarital());
        //usuario.setGeneroPersonal(usuariodetails.getGeneroPersonal());
        //usuario.setTiposCliente(usuariodetails.getTiposCliente());
        Usuarios updateMovie = usuariosRepository.save(usuario);
        return updateMovie;
    }

    //Eliminar Usuario
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long noteId) {
        Usuarios usuario = usuariosRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
        credencialRepository.delete(usuario.getCredencial());
        usuariosRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }
}
