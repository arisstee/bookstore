package com.tea.bookstore.controller;

import com.tea.bookstore.entity.Customer;
import com.tea.bookstore.entity.Genre;
import com.tea.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    //get all customers
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = service.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //get customer by id
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Customer customer = service.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    //create a new customer
    @PostMapping("/createNewCustomer")
    public ResponseEntity<String> createNewCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return new ResponseEntity<>("New customer created successfully!!", HttpStatus.CREATED);
    }

    //update customer paramether
    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
        return new ResponseEntity<>("Customer Updated Successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Customer customer) {
        service.deleteCustomer(customer);
        return new ResponseEntity<>("Customer deleted successfully!!!!", HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Customer>> sort(){
        List<Customer> customers= service.sort();
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
}