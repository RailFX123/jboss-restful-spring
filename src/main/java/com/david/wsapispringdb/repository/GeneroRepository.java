/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.david.wsapispringdb.model.Genero;
import com.david.wsapispringdb.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
