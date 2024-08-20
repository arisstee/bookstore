package com.tea.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "genre")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Genre {

    @Id
    private Integer idgenre;
    @Column
    private String genre_name;

}
