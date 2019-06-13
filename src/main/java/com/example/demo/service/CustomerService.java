package com.example.demo.service;


import com.example.demo.domain.dto.Customer;
import com.example.demo.domain.request.CustomerRegistration;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    Customer saveCustomer(CustomerRegistration customerRegistration);

    Customer updateCustomer(CustomerRegistration customerRegistration);
}
