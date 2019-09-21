/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;

import com.david.wsapispringdb.model.Intereses;
import com.david.wsapispringdb.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface InteresesRepository extends JpaRepository<Intereses, Long> {

    @Query("SELECT u FROM Intereses u WHERE u.cantidadCuotas.Cantidad_Cuotas = ?1")
    Optional<Intereses> findQuotaByValue(Long id);

}
