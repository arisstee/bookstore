package com.tea.bookstore.repository;

import com.tea.bookstore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {

    @Query(nativeQuery = true,value = "Select   o.order_id, b.title" +
            " from bookstore.orderitem o " +
            "join bookstore.book b on o.book_id=b.idbook where o.book_id= :id")
    List<Object[]> BookOrder(@Param("id") Integer id);

}
