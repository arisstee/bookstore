package com.tea.bookstore.service;
import com.tea.bookstore.entity.Author;
import com.tea.bookstore.entity.Book;
import com.tea.bookstore.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repository;

    public List<Author> findAll(){
        return repository.findAll();
    }

    public Author findByName(String name){
        return repository.findByAuthorName(name);
    }

    @Transactional
    public void updateAuthor(Author author) {
        repository.updateAuthor(author.getAuthor_name(), author.getAuthor_birth_year(), author.getIdauthor());
    }


    @Transactional
    public void saveAuthor(Author author) {
        repository.save(author);
    }


    public List<Object[]> getAuthorByBookId(Integer id) {
        return repository.findBookAuthor(id);
    }

    public List<Author> getAllAuthorsSortedByBirthYear() {
        return repository.findAllSortedByBirthYear();
    }

}
