package com.tea.bookstore.repository;
import com.tea.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query(nativeQuery = true, value = "update bookstore.genre set genre_name= :name where idgenre= :id")
    public void updateGenre(String name, Integer id);

    @Query(nativeQuery = true, value = "select * from bookstore.genre " +
            "order by genre_name asc")
    List<Genre> sortByGenreName();

}
