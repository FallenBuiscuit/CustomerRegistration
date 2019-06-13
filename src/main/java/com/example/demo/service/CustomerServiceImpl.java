package com.example.demo.service;

import com.example.demo.domain.constants.CustomerConstants;
import com.example.demo.domain.dto.Customer;
import com.example.demo.domain.exception.CustomerException;
import com.example.demo.domain.request.CustomerRegistration;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Return a specific customer per id
     *
     * @param id
     * @return Customer
     */
    @Override
    public Customer findCustomerById(Long id) {
        if(ObjectUtils.isEmpty(id)){
            throw new CustomerException(CustomerConstants.C107109003);
        }
        Customer customer = customerRepository.findCustomerById(id);
        if(ObjectUtils.isEmpty(customer)){
            throw new CustomerException(CustomerConstants.C107109001);
        }
        return customer;
    }

    /**
     * Return all customers saved in the db
     *
     * @return all customers
     */
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if(CollectionUtils.isEmpty(customers)){
            throw new CustomerException(CustomerConstants.C107109002);
        }
        return customers;
    }

    /**
     * Save customer
     *
     * @param customerRegistration
     * @return
     */
    @Override
    public Customer saveCustomer(CustomerRegistration customerRegistration) {
        Customer customer = new Customer();
        if(ObjectUtils.isEmpty(customerRegistration)){
            throw new CustomerException(CustomerConstants.C107109004);
        }
        customer.setFirstName(customerRegistration.getFirstName());
        customer.setLastName(customerRegistration.getLastName());
        return customerRepository.save(customer);
    }

    /**
     * Update existing customer
     *
     * @param customerRegistration
     * @return
     */
    @Override
    public Customer updateCustomer(CustomerRegistration customerRegistration) {
        Customer customer = this.findCustomerById(customerRegistration.getId());
        customer.setFirstName(customerRegistration.getFirstName());
        customer.setLastName(customerRegistration.getLastName());
        return customerRepository.save(customer);
    }


}
