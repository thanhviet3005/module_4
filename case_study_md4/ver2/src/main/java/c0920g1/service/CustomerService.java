package c0920g1.service;

import c0920g1.model.Customer;

import java.util.List;

public interface CustomerService extends Service<Customer>{
    List<Customer> findByName(String customerName);
}
