/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;

import com.david.wsapispringdb.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    @Query("SELECT u FROM Usuarios u WHERE u.credencial.id_credencial = ?1")
     Optional<Usuarios> findUserByCredencial(Long id);
     
     @Query("SELECT u FROM Usuarios u WHERE u.credencial.correo = ?1")
     Optional<Usuarios> findUserByCredencialCorreo(String correo);
}
