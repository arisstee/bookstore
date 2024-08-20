package com.tea.bookstore.controller;

import com.tea.bookstore.entity.Order;
import com.tea.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders= service.getAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //find order with id
    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        Order order = service.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    //add a new order
    @PostMapping("/createNewOrder")
    public ResponseEntity<String> createNewOrder(@Validated @RequestBody Order order){
        service.saveOrder(order);
        return new ResponseEntity<>("New order created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<String> updateOrder(@RequestBody Order order) {
        service.updateOrder(order);
        return new ResponseEntity<>("Order Updated Successfully!", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer/name/{customerName}")
    public ResponseEntity<List<Order>> getOrdersByCustomerName(@PathVariable String customerName) {
        List<Order> orders = service.getOrdersByCustomerName(customerName);
        return new ResponseEntity<>(orders,HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody Order order){
        service.deleteOrder(order);
        return new ResponseEntity<>("Order deleted successfully!!", HttpStatus.OK);
    }



}
