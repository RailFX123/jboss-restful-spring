/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.wsapispringdb.controller;

import com.david.wsapispringdb.exception.ResourceNotFoundException;
import com.david.wsapispringdb.model.Movie;
import com.david.wsapispringdb.repository.MovieRepository;
import java.util.List;
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
@RequestMapping("/apigg")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    // Get All Notes
    @GetMapping("/movies")
    public List<Movie> getAllNotes() {
        return movieRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/movies")
    public Movie createNote(@Valid @RequestBody Movie note) {
        return movieRepository.save(note);
    }

    @GetMapping("/movies/{id}")
    public Movie getNoteById(@PathVariable(value = "id") Long noteId) {
        return movieRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", noteId));
    }

    @PutMapping("/movies/{id}")
    public Movie updateNote(@PathVariable(value = "id") Long noteId,
            @Valid @RequestBody Movie noteDetails) {

        Movie movie = movieRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", noteId));

        movie.setTitulo(noteDetails.getTitulo());
        movie.setSinopsis(noteDetails.getSinopsis());

        Movie updateMovie = movieRepository.save(movie);
        return updateMovie;
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Movie note = movieRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", noteId));

        movieRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
