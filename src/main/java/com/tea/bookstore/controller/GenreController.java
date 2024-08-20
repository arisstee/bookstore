package com.tea.bookstore.controller;

import com.tea.bookstore.entity.Genre;
import com.tea.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService service;

    //get all the genres
    @GetMapping("/getAll")
    public ResponseEntity<List<Genre>> getAll(){
        List<Genre> genres = service.getAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
    //find genre by id
    @GetMapping("/getGenreById/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Integer id){
        Genre genre = service.getGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    //add a new genre
    @PostMapping("/createNewGenre")
    public ResponseEntity<String> createNewGenre(@RequestBody Genre genre){
        service.saveGenre(genre);
        return new ResponseEntity<>("New genre created successfully", HttpStatus.CREATED);
    }
    //update genre paramether
    @PutMapping("/updateGenre")
    public ResponseEntity<String> updateGenre(@RequestBody Genre genre){
        service.updateGenre(genre);
        return new ResponseEntity<>("Genre Updated Successfully!", HttpStatus.OK);
    }

    @GetMapping("/sortGenres")
    public ResponseEntity<List<Genre>> sortGenres(){
        List<Genre> genres= service.sortGenres();
        return new ResponseEntity<>(genres,HttpStatus.OK);
    }
}
