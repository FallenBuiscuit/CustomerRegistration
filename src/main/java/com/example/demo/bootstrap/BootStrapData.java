package com.example.demo.bootstrap;

import com.example.demo.domain.dto.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Customer Data");
        List<Customer> customers = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setFirstName("Carlo");
        c1.setLastName("Ruste");

        Customer c2 = new Customer();
        c2.setFirstName("Jose");
        c2.setLastName("Bonachita");

        Customer c3 = new Customer();
        c3.setFirstName("Carl");
        c3.setLastName("Cebrecus");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        customerRepository.saveAll(customers);

        System.out.println("Customer Saved: " + customerRepository.count());

    }
}
