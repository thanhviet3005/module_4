package managing_customer_2.repository;

import managing_customer_2.model.Customer;

import java.util.List;

public interface Repository {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void update(Customer customer);
    void removeById(int id);
}
