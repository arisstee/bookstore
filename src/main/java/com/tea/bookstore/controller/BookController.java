package com.tea.bookstore.controller;
import com.tea.bookstore.entity.Book;
import com.tea.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;

    //get all books
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> book = service.getAllBooks();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    //get book by title
    @GetMapping("/getTitle/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
        Book book = service.findByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    //update an existing book
    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        service.updateBook(book);
        return new ResponseEntity<>("Book Updated Successfully!", HttpStatus.OK);
    }

    //delete book
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody Book book){
        service.deleteBook(book);
        return new ResponseEntity<>("Book deleted successfully!!", HttpStatus.OK);
    }
    //add a new book
    @PostMapping("/createNewBook")
    public ResponseEntity<String> createNewBook(@RequestBody Book book){
        service.saveBook(book);
        return new ResponseEntity<>("New book created successfully", HttpStatus.CREATED);
    }

    //get the genre of a specific book
    @GetMapping("/genre")
    public ResponseEntity<?> getBookGenre(@RequestParam String title) {
        List<Object[]> results = service.findBookGenreByTitle(title);

        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

    //get author by book id
    @GetMapping("/{bookId}/authors")
    public ResponseEntity<List<Object[]>> getAuthorsByBookId(@PathVariable Integer bookId) {
        List<Object[]> authors = service.getAuthorByBookId(bookId);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/sortByPublicationYear")
    public ResponseEntity<List<Book>> getBooksSortedByPublicationYear() {
        List<Book> books = service.getAllBooksSortedByPublicationYear();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


}

