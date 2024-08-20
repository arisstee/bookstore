package com.tea.bookstore.service;

import com.tea.bookstore.entity.Customer;
import com.tea.bookstore.entity.Genre;
import com.tea.bookstore.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> getAll(){
        return repository.findAll();
    }

    public Customer getCustomerById(Integer id){
        return (Customer) repository.getReferenceById(id);
    }

    @Transactional
    public void saveCustomer (Customer customer){
        repository.save(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer){
        repository.updateCustomer(customer.getName(),
                customer.getAge(), customer.getEmail(),
                customer.getAddress(), customer.getCustomer_id());
    }

    @Transactional
    public void deleteCustomer(Customer customer){
        repository.deleteCustomer(customer.getCustomer_id());
    }

    public List<Customer> sort(){
        return repository.sortByName();
    }
}
