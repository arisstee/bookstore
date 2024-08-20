package com.tea.bookstore.controller;

import com.tea.bookstore.entity.OrderItem;
import com.tea.bookstore.repository.OrderItemRepository;
import com.tea.bookstore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    OrderItemService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderItem>> getAll(){
        List<OrderItem> orderItemList = service.getAll();
        return new ResponseEntity<>(orderItemList, HttpStatus.OK);
    }

    @GetMapping("/{bookid}/order")
    public ResponseEntity<List<Object[]>> getOrderIdAndTitleByBookId(@PathVariable Integer bookId) {
        List<Object[]> result = service.findBookOrder(bookId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}


