package managing_customer.repository;

import managing_customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer findById(int id);
    boolean saveCustomer(Customer customer);
    void removeCustomer(int id);
    void updateCustomer(Customer customer);

}
