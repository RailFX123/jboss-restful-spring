/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;

import com.david.wsapispringdb.model.Credenciales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

    @Query("SELECT u FROM Credenciales u WHERE u.correo = ?1 and u.contrasena = ?2")
    Optional<Credenciales> findLoginUser(String correo, String contrasena);
}
