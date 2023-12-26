package com.example.demo.controllers;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Workout;
import com.example.demo.service.CustomerService;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerControllers {
    // Annotation
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save operation
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashedPassword);
        return customerService.saveCustomer(customer);
    }

    // Read operation
    @GetMapping("/customers/{id}")

    public Customer getCustomerById(@PathVariable("id") Long customerId)
    {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public Customer getCustomerByEmail(@RequestParam(name = "email") String customerEmail){
        return customerService.getCustomerByEmail(customerEmail);
    }

    // Update operation
    @PutMapping("/customers/{id}")

    public Customer
    updateCustomer(@RequestBody Customer customer,
                     @PathVariable("id") Long customerId)
    {

        return customerService.updateCustomer(
                customer, customerId);
    }

    @GetMapping("/customers/{customerId}/workouts")

    public ResponseEntity <Collection<Workout>> getWorkoutsByUserId(@PathVariable Long customerId) {
        Customer customer = getCustomerById(customerId);
        return ResponseEntity.ok(customer.getWorkouts());
    }

    // Delete operation
    /*
    @DeleteMapping("/customer/{id}")
    public String deleteCustomerById(@PathVariable("id")
                                       Long customerId)
    {

        customerService.deleteCustomerById(
                customerId);
        return "Deleted Successfully";
    }

     */
}

