/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.controller;

import com.david.wsapispringdb.exception.ResourceNotFoundException;
import com.david.wsapispringdb.model.Cuotas;
import com.david.wsapispringdb.model.MailClass;
import com.david.wsapispringdb.model.Pagos;
import com.david.wsapispringdb.model.Prestamos;
import com.david.wsapispringdb.repository.CuotasRepository;
import com.david.wsapispringdb.repository.InteresesRepository;
import com.david.wsapispringdb.repository.PrestamosRepository;
import com.david.wsapispringdb.repository.UsuarioRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/loanmanagement")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class LoanController {

    @Autowired
    UsuarioRepository usuariosRepository;

    @Autowired
    PrestamosRepository prestamosRepository;
    
    @Autowired
    CuotasRepository cuotasRepository;
    //Obtener un usuario por ID

    @Autowired
    InteresesRepository interesesRepository;

    @GetMapping("usuarios/{id}")
    public Prestamos getMovieById(@PathVariable(value = "id") Long noteId) {
        return prestamosRepository.findLoanByUserID(noteId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", noteId));
    }

    @PostMapping("prestamo")
    public Prestamos crearPrestamo(@Valid @RequestBody Prestamos prestamo) {
        prestamo.setId_cantidad_cuota(interesesRepository.findQuotaByValue(prestamo.getId_cantidad_cuota()).get().getCantidadCuotas().getId_cantidad_cuota());
        return prestamosRepository.save(prestamo);
    }

    @GetMapping("listar")
    public List<Prestamos> crearPrestamo() {
        return prestamosRepository.findAll();
    }

    @PutMapping("prestamo/estado/{id}")
    public Prestamos actualizarPrestamo(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Prestamos prestamodetails) {
        Prestamos presta = prestamosRepository.findById(noteId).orElseThrow(()
                -> new ResourceNotFoundException("Prestamo", "id", noteId));
        presta.setEstado(prestamodetails.getEstado());
        return prestamosRepository.save(presta);
    }

    @PutMapping("prestamo/cuota/{id}")
    public Cuotas PagarCuota(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Pagos cuotadetails) {
        Cuotas cuota = cuotasRepository.findById(noteId).orElseThrow(()
                -> new ResourceNotFoundException("Cuota", "id", noteId));
        cuota.setCuotasPagos(cuotadetails);
        cuota.getCuotasPagos().setPagosRealizados(cuota);
        return cuotasRepository.save(cuota);
    }

}
