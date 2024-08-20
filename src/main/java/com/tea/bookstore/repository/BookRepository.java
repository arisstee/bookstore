package com.tea.bookstore.repository;
import com.tea.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

   @Query (nativeQuery= true, value = "Select * from bookstore.book where title= :title")
           Book findByTitleIgnoreCase(String title);

   @Query(nativeQuery= true, value = "update bookstore.book set title= :title, " +
           "isbn= :isbn,publication_year= :publication_year, price= :price, quantity= :quantity, " +
           "author_id= :author, genre_id= :genre where idbook= :id ")
    public void updateBook(String title,String isbn,Integer publication_year, Integer price, Integer quantity, Integer author, Integer genre, Integer id );

   @Modifying
   @Query(nativeQuery = true, value = "delete from bookstore.book where idbook= :id")
    void deleteBook(Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "SELECT B.title, G.genre_name AS genre_name " +
            "FROM Bookstore.book B " +
            "JOIN Bookstore.genre G ON B.genre_id = G.idgenre " +
            "where b.title= :title")
    List<Object[]> findBookGenreByTitle(@Param("title") String title);

    @Modifying
    @Query(nativeQuery = true, value = "select b.title, a.author_name from bookstore.book b " +
            "join bookstore.author a on b.idbook = a.idauthor " +
            "where b.idbook= :bookId")
    List<Object[]> findAuthorsByBookId(@Param("bookId") Integer bookId);

    @Modifying
    @Query(nativeQuery = true, value = "select  * from bookstore.book order by publication_year ")
    List<Book> findAllSortedByPublicationYear();

}
