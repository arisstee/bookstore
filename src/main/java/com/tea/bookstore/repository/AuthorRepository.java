package com.tea.bookstore.repository;

import com.tea.bookstore.entity.Author;
import com.tea.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(nativeQuery = true,value = "Select * from bookstore.author where author_name= :name")
    Author findByAuthorName(String name);

    @Modifying
    @Query(nativeQuery= true, value = "update bookstore.author set author_name= :name," +
            "author_birth_year= :year where idauthor= :id ")
    public void updateAuthor(String name, Integer year, Integer id);

    @Query(nativeQuery = true, value = "Select a.author_name, B.title  " +
            "from bookstore.author a " +
            "join bookstore.book b on b.author_id=a.idauthor " +
            "where a.idauthor= :id")
    List<Object[]> findBookAuthor(Integer id);

    @Query(nativeQuery = true, value = "select  * from bookstore.author order by author_birth_year ")
    List<Author> findAllSortedByBirthYear();
}
