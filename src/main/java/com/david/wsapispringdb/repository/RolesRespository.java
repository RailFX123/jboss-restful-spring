/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.repository;

import com.david.wsapispringdb.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface RolesRespository extends JpaRepository<Roles,Long> {
    
}
