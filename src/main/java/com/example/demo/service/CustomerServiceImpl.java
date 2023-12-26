// Below is the code for the CalenderServiceImpl.java file.
package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Workout;
import com.example.demo.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    // save operation
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerByEmail(String customerEmail){
        return customerRepository.findByCustomerEmail(customerEmail);
    }

    @Override
    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerId));
    }


    @Transactional
    @Override
    public Collection<Workout> getWorkoutsByUserId(Long customerId) {
        return null;
    }

    // update operation
    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer depDB = customerRepository.findById(customerId).get();

        if (Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName())) {
            depDB.setCustomerName(customer.getCustomerName());
        }
        return customerRepository.save(depDB);
    }



}
