package com.tea.bookstore.controller;

import com.tea.bookstore.entity.Author;
import com.tea.bookstore.entity.Book;
import com.tea.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Author>> getAll(){
        List<Author> authorList = service.findAll();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Author> findByName(@PathVariable String name){
        Author author = service.findByName(name);
        return new ResponseEntity<>(author,HttpStatus.OK);

    }

    @PutMapping("/updateAuthor")
    public ResponseEntity<String> updateAuthor(@RequestBody Author author){
        service.updateAuthor(author);
        return new ResponseEntity<>("Author Updated Successfully!", HttpStatus.OK);
    }


    @PostMapping("/createNewAuthor")
    public ResponseEntity<String> createNewAuthor(@RequestBody Author author){
        service.saveAuthor(author);
        return new ResponseEntity<>("New Author created successfully", HttpStatus.CREATED);
    }


    //get author by book id
    @GetMapping("/{bookId}/authors")
    public ResponseEntity<List<Object[]>> getBookAuthor(@PathVariable Integer id) {
        List<Object[]> authors = service.getAuthorByBookId(id);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


    @GetMapping("/sortByBirthYear")
    public ResponseEntity<List<Author>> getAuthorsSortedByPublicationYear() {
        List<Author> authors = service.getAllAuthorsSortedByBirthYear();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}
