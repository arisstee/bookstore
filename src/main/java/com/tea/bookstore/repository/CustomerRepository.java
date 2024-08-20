package com.tea.bookstore.repository;

import com.tea.bookstore.entity.Customer;
import com.tea.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "update bookstore.customer set name= :name, age= :age," +
            " email= :email, address= :address where customer_id= :id ")
    void updateCustomer(String name, Integer age, String email, String address, Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "delete from bookstore.customer where customer_id= :id")
    void deleteCustomer(Integer id);

    @Query(nativeQuery = true, value = "select * from bookstore.customer " +
            "order by name desc")
    List<Customer> sortByName();


}

