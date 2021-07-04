package com.codingchallenge.demo.repository;

import com.codingchallenge.demo.model.CustomerDetails;
import com.codingchallenge.demo.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {
}
