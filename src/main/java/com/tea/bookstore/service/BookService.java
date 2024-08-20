package com.tea.bookstore.service;
import com.tea.bookstore.entity.Book;
import com.tea.bookstore.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

      @Autowired
      BookRepository repository;

     public List<Book> getAllBooks() {
            return repository.findAll();
     }
     public Book findByTitle(String title){
          return repository.findByTitleIgnoreCase(title);
     }

    //update book
    @Transactional
    public void updateBook(Book book) {
        repository.updateBook(book.getTitle(), book.getIsbn(),
                book.getPublication_year(), book.getPrice(), book.getQuantity(),
                book.getAuthor_id(),book.getGenre_id(), book.getIdbook());
    }

    //delete book
    @Transactional
    public void deleteBook(Book book) {
        repository.deleteBook(book.getIdbook());
    }

    //save a new book
    @Transactional
    public void saveBook(Book book) {
        repository.save(book);
    }

    //get book genre
    public List<Object[]> findBookGenreByTitle(String bookTitle) {
        List<Object[]> results = repository.findBookGenreByTitle(bookTitle);

        for (Object[] result : results) {
            String title = (String) result[0];
            String genreName = (String) result[1];
            System.out.println("Title: " + title + ", Genre: " + genreName);
        }
        return results;
    }

    public List<Object[]> getAuthorByBookId(Integer bookId) {
        return repository.findAuthorsByBookId(bookId);
    }

    public List<Book> getAllBooksSortedByPublicationYear() {
        return repository.findAllSortedByPublicationYear();
    }




}


