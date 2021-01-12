package c0920g1.demo.managing_customer_2.service.impl;

import c0920g1.demo.managing_customer_2.model.Customer;

import c0920g1.demo.managing_customer_2.repository.CustomerRepository;
import c0920g1.demo.managing_customer_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeById(int id) {
        customerRepository.deleteById(id);
    }

}
