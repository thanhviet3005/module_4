package c0920g1.demo.managing_customer_2.service;

import c0920g1.demo.managing_customer_2.model.Customer;


import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void removeById(int id);
}
