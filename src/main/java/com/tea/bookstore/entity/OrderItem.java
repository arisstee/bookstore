package com.tea.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity(name= "orderitem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItem {

    @Id
    private Integer order_item_id;
    @Column
    private Integer order_id;
    @Column
    private Integer book_id;
    @Column
    private Integer quantity;


}
