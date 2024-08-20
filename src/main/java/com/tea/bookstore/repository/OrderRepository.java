package com.tea.bookstore.repository;

import com.tea.bookstore.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE bookstore.ordr set " +
            "customer_id = :customerId, order_date = :date, total_amount = :amount " +
            "WHERE order_id = :id")
    int updateOrder(@Param("customerId") Integer customerId,
                    @Param("date") LocalDateTime date,
                    @Param("amount") Integer amount,
                    @Param("id") Integer id);
        @Modifying
        @Query(nativeQuery = true, value = "delete from bookstore.ordr where order_id= :id")
        void deleteOrder(Integer id);

    @Query(value = "SELECT o.* FROM bookstore.ordr o JOIN bookstore.customer c ON o.customer_id = c.customer_id " +
            "WHERE c.name = :customerName", nativeQuery = true)
    List<Order> findByCustomerNameNativeQuery(String customerName);

}
