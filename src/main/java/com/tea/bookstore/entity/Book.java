package com.tea.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class Book {

    @Id
    private Integer idbook;
    @Column
    private String title;
    @Column
    private String isbn;
    @Column(name = "publication_year")
    private Integer publication_year;
    @Column
    private Integer price;
    @Column
    private Integer quantity;
    @Column
    private Integer author_id;
    @Column
    private Integer genre_id;
}

