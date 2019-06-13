package com.example.demo.domain.response;

import com.example.demo.domain.dto.Customer;

import java.util.List;

public class RegisteredCustomer {

    private List<Customer> customer;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
