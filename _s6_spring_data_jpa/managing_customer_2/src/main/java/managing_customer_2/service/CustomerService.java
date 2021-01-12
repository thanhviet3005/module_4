package managing_customer_2.service;

import managing_customer_2.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void update(Customer customer);
    void removeById(int id);
}
