package com.tea.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Author {

    @Id
    private Integer idauthor;
    @Column
    private String author_name;
    @Column
    private Integer author_birth_year;
}
