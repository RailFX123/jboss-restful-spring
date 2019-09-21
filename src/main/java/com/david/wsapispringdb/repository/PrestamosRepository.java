/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;

import com.david.wsapispringdb.model.Prestamos;
import com.david.wsapispringdb.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface PrestamosRepository extends JpaRepository<Prestamos, Long> {

    @Query("SELECT u FROM Prestamos u WHERE u.id_usuario = ?1")
     Optional<Prestamos> findLoanByUserID(Long id);
}
