// Java Program to Illustrate DepartmentRepository.java File

// Importing package module to this code
package com.example.demo.repositories;

// Importing required classes
import com.example.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Annotation
@Repository

// Class
public interface CustomerRepository
        extends CrudRepository<Customer, Long> {
    Customer findByCustomerEmail(String customerEmail);
}
