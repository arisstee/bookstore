package com.tea.bookstore.service;

import com.tea.bookstore.entity.Order;
import com.tea.bookstore.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> getAll(){
        return repository.findAll();
    }

    public Order getOrderById(Integer id){
        return repository.getReferenceById(id);
    }
    @Transactional
    public void saveOrder(Order order){
        repository.save(order);
    }

    @Transactional
    public void updateOrder(Order order) {
        repository.updateOrder(order.getCustomer_id(), order.getOrder_date(), order.getTotal_amount(), order.getOrder_id());
    }

    @Transactional
    public void deleteOrder(Order order) {
        repository.deleteOrder(order.getOrder_id());
    }

    public List<Order> getOrdersByCustomerName(String customerName) {
        return repository.findByCustomerNameNativeQuery(customerName);
    }
}
