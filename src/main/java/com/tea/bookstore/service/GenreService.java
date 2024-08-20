package com.tea.bookstore.service;

import com.tea.bookstore.entity.Genre;
import com.tea.bookstore.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository repository;

    public List<Genre> getAllGenres(){
        return repository.findAll();
    }

    public Genre getGenreById(Integer id){
        return repository.getReferenceById(id);
    }

    @Transactional
    public void saveGenre(Genre genre){
        repository.save(genre);
    }

    @Transactional
    public void updateGenre(Genre genre){
        repository.updateGenre(genre.getGenre_name(),genre.getIdgenre());
    }

    public List<Genre> sortGenres(){
        return repository.sortByGenreName();
    }

}
