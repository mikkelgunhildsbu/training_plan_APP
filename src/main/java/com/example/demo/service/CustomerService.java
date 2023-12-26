package com.example.demo.service;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Workout;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface CustomerService {
    // save operation
    Customer saveCustomer(Customer calender);

    // read operation
    Customer getCustomerById (Long customerId);

    Customer getCustomerByEmail (String email);

    Collection<Workout> getWorkoutsByUserId (Long customerId);

    // update operation
    Customer updateCustomer(Customer customer, Long customerId);
}

