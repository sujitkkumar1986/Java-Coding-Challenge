package com.codingchallenge.demo.service;

import com.codingchallenge.demo.model.ContactList;
import com.codingchallenge.demo.model.CustomerDetails;
import com.codingchallenge.demo.model.Type;
import com.codingchallenge.demo.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Transactional
    public ResponseEntity<Object> saveCustomer(CustomerDetails customerDetails) {
        CustomerDetails savedCustomer;
        if (customerDetails.getPhone().stream().anyMatch(phone -> Type.HOME.equals(phone.getType()))) {
            savedCustomer = customerRepository.save(new CustomerDetails(null, customerDetails.getName(), customerDetails.getAddress(),customerDetails.getPhone(),customerDetails.getEmail(),"true"));
        } else {
            savedCustomer = customerRepository.save(customerDetails);
        }

        if(customerRepository.findById(savedCustomer.getId()).isPresent())
            return ResponseEntity.ok().body(savedCustomer.getId() + " Customer created successfully.");
        else
            return ResponseEntity.unprocessableEntity().body("Failed to create the Customer specified.");
    }
    @Transactional
    public ResponseEntity<Object> get(Long id) {
        CustomerDetails savedCustomer = customerRepository.findById(id).get();
        if (savedCustomer != null) {
            return ResponseEntity.ok().body(customerRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Transactional
    public List<CustomerDetails> listAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Transactional
    public ResponseEntity<Object> getCustomerCallList() {
        List<CustomerDetails> customerDetails = customerRepository.findByHome();
        Set<ContactList> contactListResponse = customerDetails.stream().map(customerDetail -> {
            String homePhone = customerDetail.getPhone().stream().filter(phone -> Type.HOME.equals(phone.getType())).findFirst().get().getNumber();
            return new ContactList(customerDetail.getName(), homePhone);
        }).collect(Collectors.toSet());
        return ResponseEntity.ok().body(contactListResponse);
    }

    @Transactional
    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long id) {
        CustomerDetails updatedCustomerDetails = new CustomerDetails(id, customerDetails.getName(), customerDetails.getAddress(),customerDetails.getPhone(),customerDetails.getEmail(),customerDetails.getHasHomePhone());
        customerRepository.save(updatedCustomerDetails);
        return ResponseEntity.accepted().body(id + " Customer created successfully.");
    }
}
