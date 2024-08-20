package com.tea.bookstore.service;

import com.tea.bookstore.entity.OrderItem;
import com.tea.bookstore.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository repository;

    public List<OrderItem> getAll(){
        return  repository.findAll();
    }

    public List<Object[]> findBookOrder(Integer id) {
        return repository.BookOrder(id);
    }

}
