package com.codingchallenge.demo.controller;

import com.codingchallenge.demo.model.CustomerDetails;
import com.codingchallenge.demo.repository.CustomerRepository;
import com.codingchallenge.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class MyContactController {
    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/contacts")
    public List<CustomerDetails> getAllCustomer() {
        return service.listAll();
    }

    @PostMapping("/contacts")
    public ResponseEntity<Object> add(@RequestBody CustomerDetails customerDetails) {
        return service.saveCustomer(customerDetails);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/contacts/call-list")
    public ResponseEntity<?> getCustomerCallList() {
        return service.getCustomerCallList();
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerDetails customerDetails, @PathVariable Long id) {
        try {
            //Get the customer to check if a customer exists.
            CustomerDetails customerIn = repository.findById(id).get();
            service.updateCustomer(customerDetails, customerIn.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
