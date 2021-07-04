package com.codingchallenge.demo.repository;

import com.codingchallenge.demo.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

    List<CustomerDetails> findByHome();
}
